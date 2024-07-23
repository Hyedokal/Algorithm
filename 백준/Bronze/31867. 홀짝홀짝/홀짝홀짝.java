import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] K = br.readLine().split("");
        int odd = 0;
        int even = 0;
        
        for(int i=0; i<N; i++){
            if(Integer.parseInt(K[i]) % 2 == 0){
                even++;
            } else odd++;
        }
        if(odd < even) System.out.println(0);
        else if(odd > even) System.out.println(1);
        else System.out.println(-1);
    }
}
