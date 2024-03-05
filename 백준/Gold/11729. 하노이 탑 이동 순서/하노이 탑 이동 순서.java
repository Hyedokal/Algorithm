import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        sb.append((int)Math.pow(2, N)-1).append("\n");
        recur(N, 1, 2, 3);
        System.out.println(sb);
    }
    static void recur(int N, int start, int mid, int to){
        if(N == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }
        // N번 원판을 1번 기둥에서 3번 기둥으로 옮길 때:
        // 1. N-1개를 1번 기둥에서 2번 기둥으로 옮긴다.
        recur(N-1, start, to, mid);
        // 2. N번 원판을 1번에서 3번으로 옮긴다.
        sb.append(start).append(" ").append(to).append("\n");
        // 3. N-1개 원판을 2번에서 3번으로 옮긴다.
        recur(N-1, mid, start, to);
    }
}