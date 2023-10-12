import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subject = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] scores = new int[subject];
        int max = 0;
        int sum = 0;
        for(int i=0; i<s.length; i++){
            scores[i] = Integer.parseInt(s[i]);
            max = Math.max(max, scores[i]);
            sum += scores[i];
        }
        System.out.println((double) sum / max / subject * 100);

    }

}