import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder temp1 = new StringBuilder(s[0]);
        StringBuilder temp2 = new StringBuilder(s[1]);
        int A = Integer.parseInt(temp1.reverse().toString());
        int B = Integer.parseInt(temp2.reverse().toString());
        System.out.println(Math.max(A, B));
    }

}
