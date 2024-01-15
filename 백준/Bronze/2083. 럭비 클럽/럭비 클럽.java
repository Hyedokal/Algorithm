import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("#")) break;
            if(Integer.parseInt(s[1]) > 17 || Integer.parseInt(s[2]) >= 80){
                System.out.println(s[0] + " Senior");
            } else{
                System.out.println(s[0] + " Junior");
            }
        }

    }

}
