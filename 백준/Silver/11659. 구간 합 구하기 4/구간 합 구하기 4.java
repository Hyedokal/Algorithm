import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] prefix;
    static int N, M;
    //idea: prefix 배열 만들어서 해결하기.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        prefix = new int[N];
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            if(i==0) prefix[i] = Integer.parseInt(s[i]);
            else prefix[i] = Integer.parseInt(s[i]) + prefix[i-1];
        }
        for(int t=0; t<M; t++){
            s = br.readLine().split(" ");
            int j = Integer.parseInt(s[1])-1;
            int i = Integer.parseInt(s[0])-2;
            if(i==-1) sb.append(prefix[j]).append("\n");
            else sb.append(prefix[j]-prefix[i]).append("\n");
        }
        System.out.println(sb);
    }
}