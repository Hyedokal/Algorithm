import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> queue;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("push")){
                queue.add(Integer.parseInt(s[1]));
            }else if(s[0].equals("pop")){
                int answer = queue.isEmpty()? -1: queue.remove(0);
                System.out.println(answer);
            }else if(s[0].equals("size")){
                System.out.println(queue.size());
            }else if(s[0].equals("empty")){
                int answer = queue.isEmpty()? 1:0;
                System.out.println(answer);
            }else if(s[0].equals("front")){
                int answer = queue.isEmpty()? -1: queue.get(0);
                System.out.println(answer);
            }else if(s[0].equals("back")){
                int answer = queue.isEmpty()? -1: queue.get(queue.size()-1);
                System.out.println(answer);
            }
        }
    }

}
