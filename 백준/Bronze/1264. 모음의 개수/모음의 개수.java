import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int count = 0;
            String str = br.readLine();
            if(str.equals("#")) break;
            for(int i=0; i<str.length(); i++){
                for(char ch : vowels){
                    if(str.charAt(i) == ch){
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
