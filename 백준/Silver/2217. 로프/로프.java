import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int N;
    static Integer[] ropes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ropes = new Integer[N];
        for(int i=0; i<N; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(ans, (i+1)*ropes[i]);
        }
        System.out.println(ans);
    }
}