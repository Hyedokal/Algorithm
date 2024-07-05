import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int count, sr, sc, apple, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int r=0; r<5; r++){
            String[] s = br.readLine().split(" ");
            for(int c=0; c<5; c++){
                board[r][c] = Integer.parseInt(s[c]);
            }
        }
        String[] s = br.readLine().split(" ");
        sr = Integer.parseInt(s[0]);
        sc = Integer.parseInt(s[1]);
        visited[sr][sc] = true;
        apple = 0;
        count = 0;
        answer = 0;
        DFS(sr, sc, apple, count);
        System.out.println(answer);
    }
    static void DFS(int r, int c, int apple, int count){
        if(count == 3){
            if(apple >= 2) answer = 1;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(0 <= nr && nr < 5 && 0 <= nc && nc < 5){
                if( !visited[nr][nc] && board[nr][nc] != -1 ){
                    visited[nr][nc] = true;
                    if(board[nr][nc] == 1){
                        DFS(nr, nc, apple+1, count+1);
                    } else {
                        DFS(nr, nc, apple, count+1);
                    }
                    visited[nr][nc] = false;
                }
            }
        }
    }
}
