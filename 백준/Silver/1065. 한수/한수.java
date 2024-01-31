import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N<100) answer = N;
        else{
            answer=99;
            for(int i=100; i<=N; i++){
                int num  = i;
                int[] arr = new int[3];
                for(int k=0; k<arr.length; k++){
                    arr[k] = num % 10;
                    num /= 10;
                }
                if((arr[0] - arr[1]) == (arr[1]-arr[2])) {
                    answer++;
                }
            }
            if(N==1000) answer--;
        }
        System.out.println(answer);
    }

}
