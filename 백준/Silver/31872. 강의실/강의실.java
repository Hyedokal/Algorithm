import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    //답: 며칠 연속으로 밥을 얻어먹을 수 있는가?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] ans = new int[N];
        ans[0] = arr[0];
        int idx = 1;
        for(int i=1; i<N; i++){
            ans[idx++] = arr[i] - arr[i-1];
        }
        Arrays.sort(ans);
//        System.out.println(Arrays.toString(ans));
        int answer = 0;
        for(int i=0; i<N-K; i++){
            answer += ans[i];
        }
        System.out.println(answer);
    }
}
