import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] paint; //n*m 행렬
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; //상하좌우
    static boolean[][] visited; //방문여부 배열
    static int n; //세로 크기 (즉 행의 개수)
    static int m; //가로 크기 (즉 열의 개수)
    static int count; //그림 개수
    static int maxArea; //최대 면적
    static int size; // DFS를 수행할 때 임시 면적을 저장하는 값. (즉 재귀 횟수 카운트)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        paint = new int[n][m];
        visited = new boolean[n][m];
        for(int r=0; r<n; r++){
            s = br.readLine().split(" ");
            for(int c=0; c<m; c++){
                paint[r][c] = Integer.parseInt(s[c]);
            }
        }
        count = 0;
        maxArea = 0;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                size = 1;
                if(!visited[r][c] && paint[r][c]==1){ //아직 방문 안한 1이 있으면..
                    count++; //그림 개수 증가시킨다.
                    DFS(r, c, 1); //DFS 알고리즘 수행
                    if(size > maxArea) maxArea = size;
                }
            }
        }
        System.out.println(count);
        System.out.print(maxArea);
    }
    static void DFS(int r, int c, int tmpArea){
        //방문처리
        visited[r][c] = true;
        for(int k=0; k<4; k++){
            int nR = r+dr[k];
            int nC = c+dc[k];
            //유효성 검사
            if(nR >= 0 && nR < n && nC >= 0 && nC < m){
                //만약 방문하지 않은 1을 찾으면..
                if(!visited[nR][nC] && paint[nR][nC]==1){
                    //재귀 수행.
                    DFS(nR, nC, tmpArea+1);
                    size++; //재귀 횟수 카운트
                }
            }
        }
        //가장 넓은 그림의 넓이 저장
        if(tmpArea > maxArea) maxArea = tmpArea;
    }
}