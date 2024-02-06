import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N; //행 개수
    static int M; //열 개수
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; //상하좌우
    static int T; //경계값
    static int[][] map;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        // 2차원배열 초기화
        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                int color = 0;
                for(int k=0; k<3; k++){
                    color += Integer.parseInt(s[3*j+k]);
                }
                map[i][j] = color;
            }
        }
        T = Integer.parseInt(br.readLine()); //경계값 초기화
        T *= 3;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                //경계값을 통해 map값을 255 혹은 0으로 초기화
                if(map[i][j] >= T) map[i][j] = 255;
                else map[i][j] = 0;
            }
        }
        //물체 개수 세기
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(!visited[r][c] && map[r][c] == 255) {
                    DFS(r, c);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    static void DFS(int r, int c){
        visited[r][c] = true; //방문 처리
        for(int k=0; k<4; k++){
            int nR = r+dr[k];
            int nC = c+dc[k];
            //유효성 검사
            if(0 <= nR && nR<N && 0 <= nC && nC<M){
                //아직 방문 안한 물체블록이면
                if(map[nR][nC] == 255 && !visited[nR][nC]) DFS(nR, nC);
            }
        }
    }
}
