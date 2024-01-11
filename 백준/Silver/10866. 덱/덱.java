import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> deque;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        deque = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("push_front")){
                deque.add(0, Integer.parseInt(s[1]));
            }else if(s[0].equals("push_back")){
                deque.add(Integer.parseInt(s[1]));
            }else if(s[0].equals("pop_front")){
                int answer = deque.isEmpty()? -1:deque.remove(0);
                System.out.println(answer);
            }else if(s[0].equals("pop_back")){
                int answer = deque.isEmpty()? -1:deque.remove(deque.size()-1);
                System.out.println(answer);
            }else if(s[0].equals("size")){
                System.out.println(deque.size());
            }else if(s[0].equals("empty")){
                int answer = deque.isEmpty()? 1:0;
                System.out.println(answer);
            }else if(s[0].equals("front")){
                int answer = deque.isEmpty()? -1:deque.get(0);
                System.out.println(answer);
            }else if(s[0].equals("back")){
                int answer = deque.isEmpty()? -1:deque.get(deque.size()-1);
                System.out.println(answer);
            }
        }
    }

}
