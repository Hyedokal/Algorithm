import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] A = new int[N];
        int[] B = new int[N];
        int idx = 0;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(s[i]);
        }

        for(int i=1; i<=1000; i++){
            for(int j=0; j<N; j++){
                if(A[j] == i){
                    B[j] = idx++;
                }
            }
        }

        String answer = "";
        for(int i=0; i<N-1; i++){
            answer += B[i] + " ";
        }
        answer += B[N-1];
        System.out.println(answer);
    }
}