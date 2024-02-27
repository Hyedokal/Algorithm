import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int M, N, days;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> queue;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        map = new int[N][M];
        queue = new LinkedList<>();
        for(int r=0; r<N; r++){
            s = br.readLine().split(" ");
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(s[c]);
                if(map[r][c] == 1) {
                    queue.offer(new int[]{r, c, 0}); //시작점, 일 수 저장
                }
            }
        }
        BFS();

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(map[r][c] == 0){
                    days = -1;
                    break;
                }
            }
        }
        System.out.println(days);
    }

    static void BFS(){
        while(!queue.isEmpty()){
            int[] coor = queue.poll();
            map[coor[0]][coor[1]] = 1;
            int day = coor[2];
            for(int k=0; k<4; k++){
                int newR = coor[0]+dr[k];
                int newC = coor[1]+dc[k];
                if(newR >= 0 && newR < N && newC >= 0 && newC < M){
                    if(map[newR][newC] == 0){
                        map[newR][newC] = day+1;
                        queue.offer(new int[]{newR, newC, day+1});
                        count++;
                        days = day+1;
                    }
                }
            }
        }
    }
}