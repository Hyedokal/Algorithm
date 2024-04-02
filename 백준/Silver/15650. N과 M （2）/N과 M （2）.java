import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, arr[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        comb(1, 0);
        System.out.println(sb);
    }
    static void comb(int n, int count){
        if(count == M){
            for (int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        if(n > N) return;
        arr[count] = n;
        comb(n+1, count+1);
        comb(n+1, count);
    }
}