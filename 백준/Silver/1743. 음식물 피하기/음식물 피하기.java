import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; //우상좌하
    static int N;   //세로 길이
    static int M;   //가로 길이
    static int K;   //음쓰 개수
    static int[][] myMap;
    static boolean[][] visited;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        myMap = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        K = Integer.parseInt(st.nextToken());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            myMap[r][c] = 1;    //음쓰가 있는 곳은 1로 나타냄.
        }
        br.close();

        size = 0; //답을 저장할 변수.
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(myMap[i][j] == 1 && !visited[i][j]) {
                    size = Math.max(size, BFS(new int[]{i, j}));
                }
            }
        }
        System.out.print(size);
    }
    static int BFS(int[] rc){
        Queue<int[]> q = new LinkedList<>();
        int count = 1;
        q.offer(rc);
        while(!q.isEmpty()){
            int[] now = q.poll();
            visited[now[0]][now[1]] = true;
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                //유효성 검사
                if(x >= 1 && y >= 1 && x<=N && y<=M){
                    if(myMap[x][y] == 1 && !visited[x][y]){
                        count++;
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return count;
    }

}