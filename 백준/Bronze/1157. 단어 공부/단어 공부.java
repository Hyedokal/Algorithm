import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] count = new int[27]; 
        for (char ch : chars) {
            if (ch - 96 > 0) {
                count[ch - 96]++;
            } else {
                count[ch - 64]++;
            }
        }
        int[] copy = new int[27];
        System.arraycopy(count, 0, copy, 0, count.length);

        Arrays.sort(copy);
        if (copy[copy.length - 1] == copy[copy.length - 2]) {
            System.out.println("?");
        } else {
            int idx = 1;
            int temp = copy[copy.length - 1];
            while (true) {
                if (count[idx] == temp) {
                    char c = (char) (idx + 64);
                    System.out.println(c);
                    break;
                }
                idx++;
            }
        }
    }
}