import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M, min;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];
        min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int st = 0;
        int ed = 0;
        while(ed<N && st<N){
            int tmp = arr[ed]-arr[st];
            if(tmp < M) ed++;
            else {
                if(tmp < min)  min = tmp;
                st++;
            }
        }
        System.out.println(min);
    }
}
