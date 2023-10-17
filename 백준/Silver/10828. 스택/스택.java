import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            if(s.length == 2){
                stack.push(Integer.parseInt(s[1]));
            } else{
                if(s[0].equals("pop")){
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    } else{
                        System.out.println(stack.pop());
                    }
                } else if (s[0].equals("size")) {
                    System.out.println(stack.size());
                } else if(s[0].equals("empty")){
                    if(stack.isEmpty()){
                        System.out.println(1);
                    } else System.out.println(0);
                } else if(s[0].equals("top")){
                    if(!stack.isEmpty()){
                        System.out.println(stack.peek());
                    } else{
                        System.out.println(-1);
                    }
                }
            }
        }
    }
}