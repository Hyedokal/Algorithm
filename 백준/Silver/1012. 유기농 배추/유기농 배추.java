import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //N*M 행렬.
    static int[][] map;
    static boolean[][] visited; //방문 여부 배열
    static int count; //정답
    static int M;
    static int N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1}; //상하좌우
    //1들의 구역 개수 세기.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테케 갯수
        for(int t=0; t<T; t++){
            count = 0;
            String[] s = br.readLine().split(" ");
            M = Integer.parseInt(s[0]); //가로 길이 (열 개수)
            N = Integer.parseInt(s[1]); //세로 길이 (행 개수)
            int K = Integer.parseInt(s[2]); //배추 위치 인덱스 개수
            map = new int[N][M];
            visited = new boolean[N][M];
            for(int j=0; j<K; j++){ //배추 인덱스 저장
                String[] temp = br.readLine().split(" ");
                int row = Integer.parseInt(temp[1]); //행 번호
                int col = Integer.parseInt(temp[0]); //열 번호
                map[row][col] = 1;  //맵 정보 초기화
            }

            for(int i=0; i<N; i++){
                for(int j=0;j<M;j++){
                    if(map[i][j] == 1 && !visited[i][j]){ //배추가 심어져 있고 아직 방문 안 했으면..
                        count++; //구역 개수를 추가한다.
                        DFS(i, j); // DFS를 수행한다.
                    }
                }
            }
            System.out.println(count);



        }
    }

    static void DFS(int row, int col){
        visited[row][col] = true;
        //상하좌우 검색.
        for(int i=0; i<4; i++){
            int newR = row + dr[i];
            int newC = col + dc[i]; //새로운 좌표
            //유효성 검사
            if(newR >= 0 && newR < N && newC >= 0 && newC < M){
                if(map[newR][newC] == 1 && !visited[newR][newC]){
                    DFS(newR, newC);
                }
            }
        }
    }
}


