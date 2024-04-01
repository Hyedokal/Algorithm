import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> queue = new PriorityQueue();

    public static void main(String[] args) throws IOException {
        int rpt = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < rpt; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while (queue.size() != 1) {
            int a = queue.poll();
            int b = queue.poll();
            int sum = a + b;
            answer += sum;
            queue.add(sum);
        }

        System.out.println(answer);
    }
}