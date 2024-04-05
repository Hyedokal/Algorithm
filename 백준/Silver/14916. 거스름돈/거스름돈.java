import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1]; // 0 ~ N
        if(N==1) System.out.println(-1);
        else if(N==2) System.out.println(1);
        else if(N==3) System.out.println(-1);
        else if(N==4) System.out.println(2);
        else if(N==5) System.out.println(1);
        else{
            dp[2] = 1;
            dp[4] = 2;
            dp[5] = 1;
            for(int i=6; i<N+1; i++){
                int a = (dp[i-2]!=0)? dp[i-2] : 99999999;
                int b = (dp[i-5]!=0)? dp[i-5] : 99999999;
                dp[i] = Math.min(a, b)+1;
            }
            if(dp[N] == 0) dp[N] = -1;
            System.out.println(dp[N]);
        }
    }
}