import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, arr[], min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        min = 100000;
        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(stk.nextToken());
        int st = 0;
        int ed = 0;
        int tmp = 0;
        while(ed < N && st < N){
            tmp += arr[ed];
            if(tmp >= S){
                while(tmp >= S) {
                    tmp -= arr[st++];
                }
                if(ed+2-st < min) min = ed+2 -st;
            }
            ed++;
        }
        if(min == 100000) min = 0;
        System.out.println(min);
    }
}