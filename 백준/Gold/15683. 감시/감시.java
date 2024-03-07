import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static int N, M, liSize, answer;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1}; //상좌하우(시계방향)
    static List<CCTV> tvList;
    static List<int[]> visitList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        answer = N*M;
        tvList = new ArrayList<>();
        visitList = new ArrayList<>();
        for(int r=0; r<N; r++){
            s = br.readLine().split(" ");
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(s[c]);
                //CCTV면 리스트에 저장
                if(1<= map[r][c] && map[r][c]<=5){
                    tvList.add(new CCTV(r, c, map[r][c]));
                }
            }
        }
        liSize = tvList.size();
        recur(0);
        System.out.println(answer);
    }

    static void recur(int tvIdx){
        if(tvIdx==liSize) {
            int temp = 0;
            //0개수를 세는 작업 후 answer 업데이트..
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    if(map[r][c] == 0) temp++;
                }
            }
            if(answer > temp) answer =temp;
            return;
        }

        //recursive case
        CCTV tv = tvList.get(tvIdx);
        switch (tv.num){
            case 1:
                for(int i=0; i<4; i++){
                    watch(tv.posR, tv.posC, tvIdx, i);
                    recur(tvIdx+1);
                    pretend(tvIdx);
                }
                break;
            case 2:
                for(int i=0; i<2; i++){
                    watch(tv.posR, tv.posC, tvIdx, i);
                    watch(tv.posR, tv.posC, tvIdx, i+2);
                    recur(tvIdx+1);
                    pretend(tvIdx);
                }
                break;
            case 3:
                for(int i=0; i<4; i++){
                    watch(tv.posR, tv.posC, tvIdx, i);
                    watch(tv.posR, tv.posC, tvIdx, (i+1)%4);
                    recur(tvIdx+1);
                    pretend(tvIdx);
                }
                break;
            case 4:
                for(int i=0; i<4; i++){
                    watch(tv.posR, tv.posC, tvIdx, i);
                    watch(tv.posR, tv.posC, tvIdx, (i+1)%4);
                    watch(tv.posR, tv.posC, tvIdx, (i+2)%4);
                    recur(tvIdx+1);
                    pretend(tvIdx);
                }
                break;
            default:
                watch(tv.posR, tv.posC, tvIdx, 0);
                watch(tv.posR, tv.posC, tvIdx, 1);
                watch(tv.posR, tv.posC, tvIdx, 2);
                watch(tv.posR, tv.posC, tvIdx, 3);
                recur(tvIdx+1);
                pretend(tvIdx);
                break;
        }
    }

    //1: 0 / 1 / 2 / 3
    //2: 0 2 / 1 3
    //3: 0 1 2 / 1 2 3 / 2 3 0 / 3 0 1
    //4: 0 1 2 3
    static void watch(int r, int c, int tvIdx, int idx){
        int count= 1;
        while(true){
            int newR = r + dr[idx]*count;
            int newC = c + dc[idx]*count;
            if(0 <= newR && newR<N && 0 <= newC && newC < M){
                //벽을 만나면 더이상 감시할 수 없다.
                if(map[newR][newC]==6) break;
                if(map[newR][newC]==0) {
                    map[newR][newC] = 9; //9는 감시중이라는 뜻
                    visitList.add(new int[]{newR, newC, tvIdx});
                }
                count++;
            } else break;
        }
    }
    //안한척 하는 함수
    static void pretend(int tvIdx){
        for(int i=visitList.size()-1; i>=0; i--){
            if(visitList.get(i)[2] == tvIdx) {
                int[] tmp = visitList.remove(i);
                map[tmp[0]][tmp[1]] = 0;
            }
            else break;
        }
    }
    static class CCTV{
        int posR, posC;
        int num;
        CCTV(int posR, int posC, int num){
            this.posR = posR;
            this.posC = posC;
            this.num = num;
        }
    }
}
