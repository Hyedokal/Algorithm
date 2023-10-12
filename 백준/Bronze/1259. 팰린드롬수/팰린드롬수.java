import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.equals("0")) break;
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            if(s.contentEquals(sb.reverse())){
                System.out.println("yes");
            } else{
                System.out.println("no");
            }
        }
    }

}