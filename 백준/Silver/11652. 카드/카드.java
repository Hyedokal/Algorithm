import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            long key = Long.parseLong(br.readLine());
            if(map.containsKey(key)) map.put(key, map.get(key)+1);
            else map.put(key, 1);
        }
        long answer = 0;
        int quantity = 0;
        for(long key : map.keySet()){
            int tmp = map.get(key);
            if(tmp > quantity){
                answer = key;
                quantity = tmp;
            } else if(tmp == quantity){
                answer = Math.min(key, answer);
            }
        }
        System.out.println(answer);
    }
}