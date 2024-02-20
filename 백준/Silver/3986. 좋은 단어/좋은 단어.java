import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<N; i++){
            stack.clear();
            char[] word = br.readLine().toCharArray();
            for(char ch : word){
                if(stack.isEmpty()) stack.push(ch);
                else{
                    if(stack.peek() == ch) stack.pop();
                    else stack.push(ch);
                }
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
