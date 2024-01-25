import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //#: 울타리, o: 양, v: 늑대
    static int R;
    static int C;

    static char[][] map;
    static boolean[][] visited;

    static int sheep =0; // 살아있는 양 수
    static int wolf =0; // 살아있는 늑대 수

    static int tmpSheep;
    static int tmpWolf;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();   //map 초기화
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                tmpSheep = 0;
                tmpWolf = 0;
                //DFS 수행
                DFS(r,c);
                if(tmpWolf >= tmpSheep) wolf += tmpWolf;
                else sheep += tmpSheep;
            }
        }
        System.out.println(sheep + " " + wolf);

    }

    //DFS 알고리즘
    static void DFS(int r, int c){
        //만약 (r,c)가 벽이 아니고, 아직 방문하지 않았다면..
        if(map[r][c] != '#' && !visited[r][c]){
            //방문 체크
            visited[r][c] = true;
            //양 칸일 경우 양 추가
            if(map[r][c] == 'o') tmpSheep++;
            //늑대 칸일 경우 늑대 추가
            else if (map[r][c] == 'v') tmpWolf++;

            //상하좌우 탐색
            for(int k=0; k<4; k++){
                int nR = r + dr[k];
                int nC = c + dc[k];
                //유효성 검사
                if(nR >= 0 && nR<R && nC >= 0 && nC<C){
                    DFS(nR, nC);
                }
            }
        }
    }
}


