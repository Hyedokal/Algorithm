import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

   static int K;
   static int temp;
   static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        list = new LinkedList<>();
        int answer = 0;
        for(int i=0; i<K; i++){
            temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                answer -= list.remove(list.size()-1);
            } else{
                list.add(temp);
                answer += temp;
            }
        }
        System.out.println(answer);
    }

}
