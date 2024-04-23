import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, K, arr[], max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(stk.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        int st = 0;
        int ed = 0;
        while(ed < N && st < N){
            int num = arr[ed];
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num) > K){
                while(true){
                    int tmp = arr[st];
                    map.put(tmp, map.get(tmp)-1);
                    st++;
                    if(tmp == num) break;
                }
            } else {
                if(ed+1-st > max) max = ed+1-st;
            }
            ed++;
        }
        System.out.println(max);
    }
}