import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;   //재료 개수
    static int M;   //갑옷을 만드는 데 필요한 수

    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        List<Integer> materials = new ArrayList<>();
        for(String string : s){
            materials.add(Integer.parseInt(string));
        }
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(materials.get(i) + materials.get(j) == M){
                    count++;
                }
            }
        }
        System.out.print(count);
    }

}