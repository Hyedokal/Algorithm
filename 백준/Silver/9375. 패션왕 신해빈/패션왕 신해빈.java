import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0)+1);
            }
            int sum = 1;
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                sum *= (entry.getValue()+1);
            }
            sb.append(sum-1).append("\n");
        }
        System.out.println(sb);
    }
}