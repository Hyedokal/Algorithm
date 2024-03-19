import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            queue.offer(Integer.parseInt(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll()).append("\n");
        }
        System.out.println(sb);
    }

}