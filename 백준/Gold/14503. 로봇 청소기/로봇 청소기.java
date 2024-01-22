import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj14503
public class Main {
    static int N; //행 개수
    static int M; //열 개수
    static int r; //첫 행 좌표
    static int c; //첫 열 좌표
    static int d; //로봇청소기가 처음 바라보는 방향 (0: 북쪽. 1: 동쪽, 2: 남쪽, 3: 서쪽)
    static int count = 0; //청소한 방 개수
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1}; //상좌하우(북동남서)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        s = br.readLine().split(" ");
        // 시작 좌표 저장
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);

        // 바라보는 방향 저장
        d = Integer.parseInt(s[2]);

        for(int i=0; i<N; i++){
            //map 배열 초기화
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        clean(r, c);
        System.out.println(count);

    }

    //청소하면 100 으로 표시
    static void clean(int r, int c){
        int temp = 0;
        //현재 칸이 청소되지 않은 경우 청소하고 count++
        if(map[r][c] == 0) {
            map[r][c] = 100;
            count++;
        }

        //주변 방 탐색
        for(int i=0; i<4; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];
            //청소가 되어있지 않은 방 개수 세기
            if(map[newR][newC] == 0) temp++;
        }

        //현재 칸의 주변 4칸이 모두 청소되어 있는 경우 ...
        if(temp == 0){
            int newR = r - dr[d];
            int newC = c - dc[d];
            //후진이 가능하면...
            if(map[newR][newC] != 1){
                //한 칸 후진 후 같은 작업 반복
                clean(newR, newC);
            }
        } else{ //현재 칸의 주변 4칸 중 청소되지 않은 칸이 있는 경우...
            //4칸 탐색
            for(int i=0; i<4; i++){
                //반시계방향으로 90도 회전
                d--;
                if(d<0) d+=4;
                //바라보는 방향 기준 앞쪽 칸이 청소되지 않은 빈 칸일 경우...
                int newR = r + dr[d];
                int newC = c + dc[d];
                if(map[newR][newC] == 0){
                    //한 칸 전진 후 같은 작업 반복
                    clean(newR, newC);
                    break;
                }
            }
        }
    }
}