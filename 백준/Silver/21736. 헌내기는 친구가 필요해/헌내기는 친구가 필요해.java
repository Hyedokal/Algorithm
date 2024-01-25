import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    
    static int row;    //현위치
    static int col;    //현위치
    static int count = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray(); //map 정보 초기화
            for(int j=0; j<M; j++){
                if(map[i][j] == 'I') {
                    row = i;
                    col = j;
                }
            }
        }
        findFriend(row, col);
        if(count == 0) System.out.println("TT");
        else System.out.println(count);
    }

    static void findFriend(int r, int c){
        visited[r][c] = true;
        for(int k=0; k<4; k++){
            int nr = r + dr[k];
            int nc = c + dc[k];
            //유효성 검사
            if(nr>=0 && nr<N && nc>=0 && nc<M){
                //만약 아직 방문하지 않았고, X가 아니면..
                if(!visited[nr][nc] && map[nr][nc] != 'X') {
                    //만약 P이면..
                    if (map[nr][nc] == 'P') count++;  //count 추가
                    findFriend(nr, nc);
                }
            }
        }
    }
}