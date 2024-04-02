import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] prefix;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefix = new int[N+1][N+1];
        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            int prev = 0;
            for (int c = 1; c <= N; c++) {
                int tmp = Integer.parseInt(st.nextToken());
                prev += tmp;
                prefix[r][c] = prev;
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int r=A; r<=C; r++){
                sum += (prefix[r][D]-prefix[r][B-1]);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}