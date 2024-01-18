import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            boolean[] door = new boolean[N+1];
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N/j; k++){
                    door[j*k] = !door[j*k];
                }
            }
            int count = 0;
            for(int k=0; k<N+1; k++){
                if(door[k]) count++;
            }
            System.out.println(count);
        }
    }
}


