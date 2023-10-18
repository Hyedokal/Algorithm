import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int target = A % B;
        int answer = 0;
        for(int i=0; i<N; i++){
            answer = target * 10 / B;
            target = target * 10 % B;

        }
        System.out.print(answer);
    }
}