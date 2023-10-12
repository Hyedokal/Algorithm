import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] chs = br.readLine().toCharArray();
        long hash = 0;
        for(int i=0; i<chs.length; i++){
            hash += (long) ((chs[i]-96)*Math.pow(31, i) % 1234567891);
        }
        System.out.print(hash);
    }
}