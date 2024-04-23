import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c, max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); //연속해서 먹을 접시 수
        c = Integer.parseInt(st.nextToken()); //쿠폰 번호
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = k-1;
        for(int i=start; i<=end; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        max = map.containsKey(c)? map.size():map.size()+1;
        for(int i=1; i<N; i++){
            end++;
            if(end >= N) end %= N;
            if(map.get(arr[start]) == 1) map.remove(arr[start]);
            else map.put(arr[start], map.get(arr[start])-1);
            start++;
            map.put(arr[end], map.getOrDefault(arr[end], 0)+1);
            int tmp = map.containsKey(c)? map.size():map.size()+1;
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}
