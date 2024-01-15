import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        char[] N = str[0].toCharArray();
        int B = Integer.parseInt(str[1]);
        int answer = 0;
        for(int i=N.length-1; i>=0; i--){
            if(N[i]>= 65 && N[i] <= 90){
                answer += (N[i] - 55) * (int) Math.pow(B, N.length-1-i);
            } else{
                answer += Integer.parseInt(String.valueOf(N[i]))* (int) Math.pow(B, N.length-1-i);
            }
        }
        System.out.println(answer);
    }

}
