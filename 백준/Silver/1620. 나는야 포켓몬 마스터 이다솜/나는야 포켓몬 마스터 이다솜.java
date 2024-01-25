import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static int M;
    static Map<String, Integer> nameNumMap;
    static Map<Integer, String> numNameMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 몬스터 수
        M = Integer.parseInt(s[1]); // 질문 수
        nameNumMap = new HashMap<>();
        numNameMap = new HashMap<>();
        for(int i=1; i<N+1; i++){
            String monster = br.readLine();
            nameNumMap.put(monster, i);
            numNameMap.put(i, monster);
        }

        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(str.charAt(0) >= 65 && str.charAt(0) <= 90){ //몬스터 이름을 주면..
                System.out.println(nameNumMap.get(str));
            } else{
                System.out.println(numNameMap.get(Integer.parseInt(str)));
            }
        }
    }

}


