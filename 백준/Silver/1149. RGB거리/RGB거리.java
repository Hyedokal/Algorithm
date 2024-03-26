import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int N;
    //dp 배열: (R/G/B비용, 이 집에 R/G/B칠했을 때 누적 비용 총 6열)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][6];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //각 색깔별 비용 저장
            for(int j=0; j<3; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
                if(i==0) dp[i][j+3] = dp[i][j];
            }
            if(i != 0){
                //예를 들어 "이번 집에 빨강 칠했을 때의 누적비용" = "전 집 지붕이 초록/파랑인 비용 중 최솟값"+"빨강 값"
                dp[i][3] = dp[i][0]+Math.min(dp[i-1][4], dp[i-1][5]);
                dp[i][4] = dp[i][1]+Math.min(dp[i-1][3], dp[i-1][5]);
                dp[i][5] = dp[i][2]+Math.min(dp[i-1][3], dp[i-1][4]);
            }
        }
        System.out.println(Math.min(Math.min(dp[N-1][3], dp[N-1][4]), dp[N-1][5]));
    }
}