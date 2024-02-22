import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //정답 = (N+9)C9
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = 9;
        int[][] dp = new int[N+K+1][K+1]; //0~N+9, 0~9
        for(int i=0; i<dp.length; i++) dp[i][0] = 1; // nC0 = 1
        for(int i=0; i<K+1; i++) dp[i][i] = 1; //K=0이면 nCk = 1
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<=K; j++){
                dp[i][j] = (dp[i-1][j]+dp[i-1][j-1]) % 10007;
            }
        }
        System.out.println(dp[N+9][9]);
    }
}