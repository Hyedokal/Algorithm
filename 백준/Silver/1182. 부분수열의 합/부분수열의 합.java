import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, S, count;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        nums = new int[N];
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(s[i]);
        comb(0, 0, 0);
        System.out.println(count);
    }

    //파라미터: 뽑을지 말지 결정할 num의 인덱스값 / 지금까지 더한 수들의 총합 / 더한 숫자들의 수
    static void comb(int idx, int tmpSum, int cnt) {
        //끝까지 도달했을 때
        if(idx == N) {
            if(tmpSum == S && cnt != 0) count++;
            return;
        }

        //recursive
        //뽑았다
        comb(idx+1, tmpSum+nums[idx], cnt+1);
        //안뽑았다
        comb(idx+1, tmpSum, cnt);
    }
}