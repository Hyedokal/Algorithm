import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        Arrays.sort(s);
        int[] copy = new int[s.length];
        for(int i=0; i<copy.length; i++){
            copy[i] = Integer.parseInt(s[copy.length-1-i]);
        }
        for(int i : copy){
            System.out.print(i);
        }
    }
}
