import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static char[][] map2; //적록색약 맵: G/B
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean[][] visited2;
    static int zone1;
    static int zone2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        map2 = new char[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];

        for(int r=0; r<N; r++){
            char[] tmp = br.readLine().toCharArray();
            for(int c=0; c<N; c++){
                map[r][c] = tmp[c];
                if(tmp[c]=='R'){
                    map2[r][c] = 'G';
                } else{
                    map2[r][c] = tmp[c];
                }
            }
        }
        zone1 = 0;
        zone2 = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(!visited[r][c]){
                    zone1++;
                    DFS1(r, c);
                }
                if(!visited2[r][c]){
                    zone2++;
                    DFS2(r, c);
                }
            }
        }
        System.out.println(zone1 + " "+ zone2);
    }

    static void DFS1(int r, int c){
        if(!visited[r][c]) visited[r][c] = true;
        for(int k=0; k<4; k++){
            int newR = r + dr[k];
            int newC = c + dc[k];
            if(newR>=0 && newR<N && newC>=0 && newC<N ){
                if(!visited[newR][newC] && map[r][c] == map[newR][newC]){
                    DFS1(newR, newC);
                }
            }
        }
    }
    static void DFS2(int r, int c){
        if(!visited2[r][c]) visited2[r][c] = true;
        for(int k=0; k<4; k++){
            int newR = r + dr[k];
            int newC = c + dc[k];
            if(newR>=0 && newR<N && newC>=0 && newC<N ){
                if(!visited2[newR][newC] && map2[r][c] == map2[newR][newC]){
                    DFS2(newR, newC);
                }
            }
        }
    }
}