import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M, min, toRemove;
    static int[][] map;
    static int[][] aliveKfcs;
    static List<int[]> houses, kfcs;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        map = new int[N][N];
        M = Integer.parseInt(s[1]);
        houses = new ArrayList<>();
        kfcs = new ArrayList<>();
        min = Integer.MAX_VALUE;
        for(int r=0; r<N; r++){
            s = br.readLine().split(" ");
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(s[c]);
                if(map[r][c] == 1) houses.add(new int[]{r,c});
                else if(map[r][c]==2) kfcs.add(new int[]{r,c});
            }
        }
        aliveKfcs = new int[M][2];
        comb(0, 0);
        System.out.println(min);
    }
    //idea: 조합을 사용하여 치킨집들 중 폐업할 치킨집을 골라 aliveKfcs에 저장한 뒤,
    // 각 집에서 가장 가까운 치킨집들을 찾아 치킨거리(tmp)를 구한 후,
    // 모두 탐색이 끝났을 때 min과 비교해서 더 작은 값을 저장한다.

    //살아남을 곳을 뽑는 메서드
    static void comb(int idx, int cnt){
        if(cnt == M) {
            int tmpDist = updateMin();
            if(min > tmpDist) min = tmpDist;
            return;
        }
        if(idx == kfcs.size()) return;

        aliveKfcs[cnt] = kfcs.get(idx);
        comb(idx+1, cnt+1);
        comb(idx+1, cnt);
    }

    //치킨거리를 구한 후 min을 업데이트하는 메서드
    static int updateMin(){
        int tmpSum = 0;
        for(int i=0; i < houses.size(); i++){
            int[] house = houses.get(i);
            int tmpMin = 9999;
            for(int j=0; j< aliveKfcs.length; j++){
                int[] kfc = aliveKfcs[j];
                int dist = Math.abs(house[0]-kfc[0])+Math.abs(house[1]-kfc[1]);
                if(dist < tmpMin)
                    tmpMin = dist;
            }
            tmpSum += tmpMin;
        }
        return tmpSum;
    }
}