import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String[] s = br.readLine().split(" ");
            int repeat = Integer.parseInt(s[0]);
            String[] strs = s[1].split("");
            for(String temp : strs){
                System.out.print(temp.repeat(repeat));
            }
            System.out.println();
        }

    }

}
