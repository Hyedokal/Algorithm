import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();
        int i = str.equals(rev)? 1:0;
        System.out.println(i);
    }

}
