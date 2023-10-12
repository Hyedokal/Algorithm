import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] values = new int[N];
        for(int i=0; i<N; i++){
            values[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(values);
        int sum;
        int answer = 0;
        for(int i=0; i<values.length-2; i++){
            for(int j=i+1; j<values.length-1; j++){
                for(int k=j+1; k<values.length; k++){
                    sum = values[i]+values[j]+values[k];
                    if(sum <= M){
                        answer = Math.max(sum, answer);
                    }
                }
            }
        }
        System.out.print(answer);
    }
}