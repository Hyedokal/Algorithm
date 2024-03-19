import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<String> deq1 = new ArrayDeque<>();
        while(st.hasMoreTokens()) deq1.addLast(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<String> deq2 = new ArrayDeque<>();
        while(st.hasMoreTokens()) deq2.addLast(st.nextToken());

        while(true) {
            if (deq1.isEmpty()) {
                while (!deq2.isEmpty()) sb.append(deq2.poll()).append(" ");
                break;
            }
            if (deq2.isEmpty()) {
                while (!deq1.isEmpty()) sb.append(deq1.poll()).append(" ");
                break;
            }
            if(Integer.parseInt(deq1.peek()) <= Integer.parseInt(deq2.peek())){
                sb.append(deq1.poll()).append(" ");
            } else{
                sb.append(deq2.poll()).append(" ");
            }
        }
        System.out.println(sb);
    }

}