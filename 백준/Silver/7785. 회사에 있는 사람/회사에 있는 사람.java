import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if(status.equals("enter")) map.put(name, status);
            else map.remove(name);
        }
        int size = map.size();
        String[] names = new String[size];
        int idx = 0;
        Set<String> set = map.keySet();
        for(String name : set) names[idx++] = name;
        Arrays.sort(names);
        StringBuilder sb = new StringBuilder();
        for(int i=size-1; i>=0; i--){
            sb.append(names[i]).append("\n");
        }
        System.out.println(sb);
    }
}