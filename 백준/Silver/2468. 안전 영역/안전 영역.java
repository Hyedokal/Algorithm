import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj2468
public class Main {
    static int[][] map;  //지도 2차원 배열
    static boolean[][] visited;  //방문 여부
    static int min;
    static int max;
    static int answer;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1}; //상하좌우
    static int N;
    static int count;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        min = 100;
        max = 1;
        answer = 1;
        //지도 배열 초기화
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] < min) min = map[i][j];
                else if(map[i][j] > max) max = map[i][j];
            }
        }

        for(int i=min; i<max; i++) {
            height = i;
            count=0;
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    DFS(r,c);   //DFS 알고리즘 수행
                }
            }
            if(i != max-1){
                for(int r=0; r<N; r++){
                    for(int c=0; c<N; c++) {
                        visited[r][c] = false;  //방문배열 초기화
                    }
                }
            }
            if(count>answer) answer = count; //구역 수의 최대값 갱신
        }
        System.out.println(answer); //출력
    }
    static void DFS(int row, int col){
        if(map[row][col] > height) { //안 잠긴 곳 중에
            if(!visited[row][col]){ //아직 방문 안 한 곳을 발견할 경우
                count++;                  // 구역 개수를 추가하고
                visited[row][col] = true; // 방문여부를 true로 바꾼다.
            }
            for(int k=0; k<4; k++){   // 상하좌우 탐색..
                int newR = row+dr[k];
                int newC = col+dc[k];
                //유효성 검사
                if(newR>=0 && newR<N && newC>=0 && newC<N){
                    if(!visited[newR][newC] && map[newR][newC]>height){ //근처에 위치한 방문 안 한 안 잠긴 곳 발견한 경우
                        visited[newR][newC] = true; //우선 방문 배열값을 true로 바꾼 다음(count++ 방지)
                        DFS(newR, newC); //재귀를 수행한다.
                    }
                }
            }
        }
    }
}


