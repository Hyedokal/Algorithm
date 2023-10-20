import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; //우상좌하
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int count;
    static int homes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]); //map 초기화
            }
        }
        count = 1;
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    homes=1;
                    BFS(new int[]{i, j});
                    nums.add(homes);
                    count++;
                }
            }
        }

        Collections.sort(nums);
        System.out.println(count-1);
        for(int i=0; i<count-1; i++){
            System.out.println(nums.get(i));
        }
    }
    public static void BFS(int[] now){
        queue = new LinkedList<>();
        queue.offer(now);
        visited[now[0]][now[1]] = true;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int k=0; k<4; k++){
                int newX = pos[0] + dx[k];
                int newY = pos[1] + dy[k];
                //좌표 유효성 검사
                if(newX>=0 && newY>=0 && newX<N && newY<N){
                    if(map[newX][newY] != 0 && !visited[newX][newY]){
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        homes++;
                    }
                }
            }
        }

    }
}