import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//boj1292
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int[] ints = new int[B+1];
        int count = 1;
        int idx = 1;

        while(idx <= B){
            for(int i=1; i<=count; i++){
                ints[idx++] = count;
                if(idx == B+1) break;
            }
            count++;
        }

        int answer = 0;
        for(int i=A; i<=B; i++){
            answer += ints[i];
        }
        System.out.println(answer);
    }
}


