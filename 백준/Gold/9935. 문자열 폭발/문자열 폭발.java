import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = br.readLine();
        char[] target = targetStr.toCharArray();
        String exp = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(char ch : target){
            sb.append(ch);
            if(sb.length() >= exp.length()){
                if(sb.substring(sb.length()-exp.length(), sb.length()).equals(exp)){
                    sb.delete(sb.length()-exp.length(), sb.length());
                }
            }
        }
        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);
    }
}
