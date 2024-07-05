import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int I, sr, sc, tr, tc;
    static Queue<int[]> queue;
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            I = Integer.parseInt(br.readLine());
            board = new int[I][I];
            visited = new boolean[I][I];
            String[] s = br.readLine().split(" ");
            sr = Integer.parseInt(s[0]);
            sc = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            tr = Integer.parseInt(s[0]);
            tc = Integer.parseInt(s[1]);
            queue = new LinkedList<>();
            BFS();
        }
    }
    static void BFS(){
        queue.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0] == tr && tmp[1] == tc){
                System.out.println(tmp[2]);
                break;
            }
            for(int i=0; i<dr.length; i++){
                int nr = tmp[0]+dr[i];
                int nc = tmp[1]+dc[i];
                if(0 <= nr && nr < I && 0 <= nc && nc < I){
                    if(!visited[nr][nc]){
                        queue.offer(new int[]{nr, nc, tmp[2]+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
}
