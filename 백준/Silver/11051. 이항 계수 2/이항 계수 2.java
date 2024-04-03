import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        K = Math.min(N-K, K);
        dp = new int[N+1][K+1];
        dp[0][0] = 1;
        for(int r=1; r<=N; r++){
            for(int c=0; c<=K; c++){
                if(c==0 || c==r) dp[r][c] = 1;
                else dp[r][c] = (dp[r-1][c-1]+dp[r-1][c]) % 10007;
            }
        }
        System.out.println(dp[N][K]);
    }
}