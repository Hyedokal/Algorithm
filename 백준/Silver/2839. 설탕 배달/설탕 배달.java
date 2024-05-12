import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);
        dp[3] = 1;
        if(N >= 5) dp[5] = 1;
        if(N >= 6){
            for(int i=6; i<dp.length; i++){
                int A = dp[i-3];
                int B = dp[i-5];
                if(A == -1 && B != -1) dp[i] = B+1;
                else if (B == -1 && A != -1) dp[i] = A+1;
                else if (A != -1 && B != -1) dp[i] = Math.min(A, B)+1;
            }
        }
        System.out.print(dp[N]);
    }
}