import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        int length = 0;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            set.add(s);
            if(s.length() > length) length = s.length();
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i=1; i<=length; i++){
            for(String s : list){
                if(s.length() == i) System.out.println(s);
            }
        }
    }
}
