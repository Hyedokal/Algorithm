import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N; //수빈 위치
    static int K; //동생 위치
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        if(N >= K) System.out.println(N-K);
        else{
            arr = new int[200001];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(N);
            while(!queue.isEmpty()){
                if(arr[K] != 0) break;
                int now = queue.poll();
                if(now-1 >= 0 && arr[now-1] == 0){
                    queue.offer(now-1);
                    arr[now-1] = arr[now]+1;
                }
                if(now+1 < arr.length && arr[now+1] == 0){
                    queue.offer(now+1);
                    arr[now+1] = arr[now]+1;
                }
                if(now*2 < arr.length && arr[now*2] == 0){
                    queue.offer(now*2);
                    arr[now*2] = arr[now]+1;
                }
            }
            System.out.println(arr[K]);
        }
        
    }

}
