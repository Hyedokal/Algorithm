import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int count = 0;
        while(B > A){
            if(B % 2 == 0) B /= 2;
            else {
                if(B % 10 != 1){
                    count = -2;
                    break;
                }
                B = (B-1)/10;
            }
            count++;
        }
        if(B != A) count = -2;
        System.out.println(count+1);
    }
}