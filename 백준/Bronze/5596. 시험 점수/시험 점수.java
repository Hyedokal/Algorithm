import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int c1 = 0;
        for(String str : s1){
            c1 += Integer.parseInt(str);
        }
        String[] s2 = br.readLine().split(" ");
        int c2 = 0;
        for(String str : s2){
            c2 += Integer.parseInt(str);
        }
        System.out.println(Math.max(c1, c2));
    }

}
