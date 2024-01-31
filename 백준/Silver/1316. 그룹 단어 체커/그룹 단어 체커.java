import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();
            Set<Character> set = new HashSet<>();
            char current = chars[0];
            boolean isGroup = true;
            for(char ch : chars){
                // 즉 current와 다르지만 집합에 들어있지 않으면 집합에 추가한다.
                // current와 다르지만 집합에 들어있으면 반복문을 빠져나간다.
                if(current != ch){
                    if(set.contains(ch)) {
                        isGroup = false;
                        break;
                    }
                    else {
                        set.add(ch);
                        current = ch;
                    }
                }
                // current와 같고 집합에 들어있으면 넘어간다.
                // current와 같고 집합에 들어있지 않으면 집합에 넣는다.(최초1회 실행 예상)
                else{
                    if(set.contains(ch)) continue;
                    else set.add(ch);
                }
            }
            //반복문을 다 돌았지만 이상없으면 count++
            if(isGroup) count++;
        }
        System.out.println(count);
    }
}
