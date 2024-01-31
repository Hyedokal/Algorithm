import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //제목에 들어간 수의 번째
        List<Integer> list = new ArrayList<>();
        int num = 666;
        while(list.size()<N){
            if(String.valueOf(num).contains("666")) list.add(num);
            num++;
        }
        System.out.println(num-1);
    }

}
