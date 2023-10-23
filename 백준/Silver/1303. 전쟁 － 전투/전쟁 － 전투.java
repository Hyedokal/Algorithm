import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; //우상좌하
    static int WForce = 0;
    static int BForce = 0;
    static int tempW;
    static int tempB;
    static int N; //가로 크기
    static int M; //세로 크기
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        map = new char[M][N];
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j=0; j<tmp.length; j++){
                map[i][j] = tmp[j]; //map 초기화
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 'W'){
                    BFS_W(new int[]{i, j});
                    WForce += tempW * tempW;
                }
                else if(!visited[i][j] && map[i][j] == 'B'){
                    BFS_B(new int[]{i, j});
                    BForce += tempB * tempB;
                }
            }
        }

        System.out.print(WForce + " " + BForce);
    }
    static void BFS_W(int[] pos){
        queue = new LinkedList<>();
        tempW = 1;
        queue.offer(pos);
        visited[pos[0]][pos[1]] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<4; k++){
                int newX = now[0] + dx[k];
                int newY = now[1] + dy[k];
                if(newX >= 0 && newY >= 0 && newX <M && newY <N){
                    if(!visited[newX][newY] && map[newX][newY] == 'W'){
                        queue.offer(new int[]{newX, newY});
                        tempW++;
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }

    static void BFS_B(int[] pos){
        queue = new LinkedList<>();
        tempB = 1;
        queue.offer(pos);
        visited[pos[0]][pos[1]] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<4; k++){
                int newX = now[0] + dx[k];
                int newY = now[1] + dy[k];
                if(newX >= 0 && newY >= 0 && newX <M && newY <N){
                    if(!visited[newX][newY] && map[newX][newY] == 'B'){
                        queue.offer(new int[]{newX, newY});
                        tempB++;
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}