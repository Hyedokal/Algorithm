import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int[41];
        answer[1] = 1;
        answer[2] = 1;
        for(int i=3; i<41; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                System.out.println("1 0");
            }
            else System.out.println(answer[N-1] + " " + answer[N]);
        }

    }
}