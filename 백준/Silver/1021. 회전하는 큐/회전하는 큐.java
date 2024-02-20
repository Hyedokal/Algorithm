import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); //큐의 크기
        int M = Integer.parseInt(s[1]); //뽑아내려는 수의 개수
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++) deque.offer(i);
        int[] arr = new int[M];
        s = br.readLine().split(" ");
        for(int i=0; i<M; i++) arr[i] = Integer.parseInt(s[i]);
        int count = 0;
        for(int i=0; i<M; i++){
            int temp = 0;
            while(deque.peek() != arr[i]){
                deque.offer(deque.poll());
                temp++;
            }
            deque.poll();
            count += Math.min(temp, deque.size()-temp+1);
        }
        System.out.println(count);
    }
}
