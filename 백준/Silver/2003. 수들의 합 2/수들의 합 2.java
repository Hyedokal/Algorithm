import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj2003
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]); //부분합

        s = br.readLine().split(" ");
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        int count = 0;
        int idx = 0;
        int temp = 0;
        int sum = 0;
        while(true){
            //idea: 인덱스를 하나하나 추가해 가며 부분합이 M보다 같거나 클 때까지 계속 더한다.
            //부분합이 M과 같아질 경우 count++ 후 각종 변수 초기화
            //M보다 커졌을 경우 count++없이 변수 초기화.
            //temp가 마지막 인덱스까지 조사했을 경우 변수 초기화.
            //idx가 마지막 인덱스까지 갔을 경우 반복문 빠져나옴.
            if(idx == N) break;
            sum += nums[temp];
            temp++;
            if (sum == M) {
                count++;
                idx++;
                temp = idx;
                sum = 0;
            } else if(sum > M || temp == N){
                idx++;
                temp = idx;
                sum = 0;
            }
        }
        System.out.println(count);
    }
}


