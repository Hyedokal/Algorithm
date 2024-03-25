import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] dp = new int[T+1][3]; //(0~T)
        for(int i=1; i<=T; i++){
            dp[i][0] = sc.nextInt();
            if(i==1) dp[i][1] = dp[i][0];
            else {
                dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2])+dp[i][0];
                dp[i][2] = dp[i-1][1]+dp[i][0];
            }
        }
        System.out.println(Math.max(dp[T][1], dp[T][2]));
    }
}