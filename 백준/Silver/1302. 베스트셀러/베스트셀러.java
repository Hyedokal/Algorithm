import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(int i=0; i<N; i++){
            String title = br.readLine();
            if(map.containsKey(title)) map.replace(title, map.get(title), map.get(title)+1);
            else map.put(title, 1);
        }
        int max = 0;
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            if(map.get(key) > max) {
                max = map.get(key);
                answer.clear();
                answer.add(key);
            } else if(map.get(key) == max) answer.add(key);
            
        }
        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
}


