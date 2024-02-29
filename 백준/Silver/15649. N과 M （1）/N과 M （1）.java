import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] nums, result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        nums = new int[N];
        visited = new boolean[N];
        result = new int[M];
        for(int i=0; i<N; i++){
            nums[i] = i+1;
        }
        perm(0);
    }

    static void perm(int idx){
        if(idx==M){
            for(int i : result) System.out.print(i+" ");
            System.out.println();
            return;
        }
        //visited를 이용한 순열 구현.
        for(int i=0; i<N; i++){
            if(!visited[i]){
                result[idx] = nums[i];
                visited[i] = true;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}