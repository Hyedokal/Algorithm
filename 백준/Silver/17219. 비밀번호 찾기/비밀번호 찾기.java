import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static int M;
    static Map<String, String> map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 사이트 수
        M = Integer.parseInt(s[1]); // 질문 수
        map = new HashMap<>();
        for(int i=1; i<N+1; i++){
            s = br.readLine().split(" ");
            map.put(s[0], s[1]);
        }

        for(int i=0; i<M; i++){
            String str = br.readLine();
            System.out.println(map.get(str)); 
        }
    }

}