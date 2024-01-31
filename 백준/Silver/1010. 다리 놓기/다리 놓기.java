import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int R = Math.min(N, M-N);
            System.out.println(combi(M, R));
        }
    }
    static long combi(int m, int r){
        long upper = 1;
        long lower = 1;
        for(int i=0; i<r; i++){
            upper *= (m-i);
            lower *= (i+1);
            if(upper % lower == 0){
                upper /= lower;
                lower = 1;
            }
        }
        return upper / lower;

    }
}
