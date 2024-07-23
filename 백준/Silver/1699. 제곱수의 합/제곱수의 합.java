import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];
        for(int i=1; i<Math.sqrt(100001); i++){
            arr[i*i] = 1;
        }
        for(int i=2; i<100001; i++){
            int min = 999999;
            if(Math.sqrt(i) - (int)Math.sqrt(i) == 0) continue;
            for(int j=1; j<Math.sqrt(i); j++){
                min = Math.min(min, arr[i-j*j]);
            }
            arr[i] = min+1;
        }
        System.out.println(arr[N]);
    }
}
