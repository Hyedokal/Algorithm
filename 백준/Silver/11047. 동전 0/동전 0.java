import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] coins = new int[N];
        for(int i=N-1; i>=0; i--){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        int idx = 0;
        while(K != 0){
            int quantity =  K / coins[idx];
            K %= coins[idx];
            count += quantity;
            idx++;
        }
        System.out.print(count);
    }
}