import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N; //세로의 크기 즉 행의 개수
    static int M; //가로의 크기 즉 열의 개수
    static int[][] map;
    static boolean[][] visited;
    static int startR; //시작점 행번호
    static int startC; //시작점 열번호
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(s[j]); // map 초기화
                if(map[i][j] == 2) {
                    startR = i;
                    startC = j; //시작점 좌표 초기화
                } else if(map[i][j]==0){
                    visited[i][j] = true; //갈 수 없는 땅이면 이미 방문한 땅으로 저장
                }
            }
        }
        queue = new LinkedList<>();

        queue.offer(startR);
        queue.offer(startC);
        visited[startR][startC] = true;
        //시작점 값을 0으로 바꿈
        map[startR][startC] = 0;
        //BFS 알고리즘 수행
        BFS();

        //출력문
        //방문하지 않은 땅이 있다면 그 값 대신 -1을 출력
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]) {
                    System.out.print(-1 + " ");
                } else System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }

    }

    static void BFS(){
       while (true){
           if(queue.isEmpty()) break;
           int row = queue.poll();
           int col = queue.poll();
           //4방탐색
           for(int k=0; k<4; k++){
               int newR = row + dr[k];
               int newC = col + dc[k];
               //유효성 검사
               if(newR >= 0 && newR<N && newC >= 0 && newC<M){
                   //아직 방문하지 않았고 갈 수 있는 땅이라면..
                   if(!visited[newR][newC]){ //어차피 갈 수 없는 땅은 미리 방문배열 값을 true로 바꾼다
                       queue.offer(newR);
                       queue.offer(newC);
                       visited[newR][newC] = true;
                       map[newR][newC] = map[row][col]+1;
                   }
               }
           }
       }

    }
}
