import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, map[][];
    static boolean[][] visited;
    static int[] dr = {0, -1, -1};
    static int[] dc = {-1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c <M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Math.max(N, M);
        int min = Math.min(N, M);
        for(int i=0; i<min; i++){
            for(int r=i; r<N; r++){
                if(!visited[r][i]) dp(r, i);
            }
            for(int c=i; c<M; c++){
                if(!visited[i][c]) dp(i, c);
            }
        }
        //for(int[] arr : map) System.out.println(Arrays.toString(arr));
        System.out.println(map[N-1][M-1]);
    }
    static void dp(int r, int c){
        if(r==0 && c==0) return;
        int max = 0;
        for(int k=0; k<3; k++){
            int nR = r+dr[k];
            int nC = c+dc[k];
            if(0 <= nR && nR < N && 0 <= nC && nC < M){
                if(max < map[nR][nC]) max = map[nR][nC];
            }
        }
        map[r][c] += max;
        visited[r][c] = true;
    }
}