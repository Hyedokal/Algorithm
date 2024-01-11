import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

   static int N;
   static List<Integer> diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 0){
            System.out.println(0);
        } else{
            diff = new ArrayList<>();
            int answer;
            for(int i=0; i<N; i++){
                diff.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(diff);
            //절삭할 수
            int cut = (int) Math.round(N * 15.0 / 100);
            double sum = 0.0;
            for(int i = cut; i<diff.size()-cut; i++){
                sum += diff.get(i);
            }
            answer = (int) Math.round(sum / (diff.size() - (cut * 2)));
            System.out.println(answer);
        }

    }

}
