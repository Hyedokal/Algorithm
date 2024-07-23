import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M, answer;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        // 0~N
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++){
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int time = Integer.parseInt(s[2]);
            if(start == end) continue;
            if(time > graph[start][end]) graph[start][end] = time;
        }
        answer = 0;
        for(int i=1; i<N+1; i++){
            if(graph[0][i] != 0){
                recur(0, i, graph[0][i]);
            }
        }
        if(answer == 0) answer = -1;
        System.out.println(answer);
    }
    static void recur(int start, int end, int time){
        //System.out.println("start = "+ start+", end = "+end+", time = " +time);
        if(end == 0){
            for(int i=1; i<N+1; i++){
                if(!visited[i]) return;
            }
            if(answer < time) answer = time;
            return;
        }
        visited[end] = true;
        //System.out.println(Arrays.toString(visited));
        for(int i=0; i<N+1; i++){
            if(graph[end][i] != 0 && !visited[i]){
                recur(end, i, time + graph[end][i]);
            }
        }
        visited[end] = false;
    }
}
