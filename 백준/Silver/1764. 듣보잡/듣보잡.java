import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ppl = br.readLine().split(" ");
        int N = Integer.parseInt(ppl[0]);
        int M = Integer.parseInt(ppl[1]);
        String[] s = new String[N+M];
        List<String> answer = new ArrayList<>();
        int count = 0;
        for(int i=0; i<N+M; i++){
            s[i] = br.readLine();
        }
        Arrays.sort(s);
        for(int idx = 1; idx<N+M; idx++){
            if(s[idx].equals(s[idx-1])){
                count++;
                answer.add(s[idx]);
            }
        }
        Collections.sort(answer);
        System.out.println(count);
        for(String str : answer){
            System.out.println(str);
        }
    }
}