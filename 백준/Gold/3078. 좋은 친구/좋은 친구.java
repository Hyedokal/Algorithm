import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        List<String> list = new LinkedList<>();
        int[] count = new int[21]; //0 ~ 20;
        String name;
        int length;
        long answer = 0;
        for (int i = 0; i < K; i++) {
            name = br.readLine();
            length = name.length();
            list.add(name);
            answer += count[length];
            count[length]++;
        }
        for (int i = K; i < N; i++) {
            name = br.readLine();
            length = name.length();
            list.add(name);
            answer += count[length];
            count[length]++;
            name = list.remove(0);
            count[name.length()]--;
        }
        System.out.println(answer);
    }
}