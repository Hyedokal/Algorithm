import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, arr[], num[];
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        visited = new boolean[N];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<N; i++) num[i] = Integer.parseInt(s[i]);
        Arrays.sort(num);
        arr = new int[M];
        perm(0,0);
        System.out.println(sb);
    }
    static void perm(int idx, int count){
        if(count == M){
            for (int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        if(idx == N) return;
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[count] = num[i];
            perm(idx+1, count+1);
            visited[i] = false;
        }
    }
}