import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringBuilder st = new StringBuilder();
            char[] keylogs = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            Stack<Character> tempStack = new Stack<>();

            for (char log : keylogs) {
                if (log == '<') {
                    if(!stack.isEmpty()) tempStack.push(stack.pop());
                } else if (log == '>') {
                    if(!tempStack.isEmpty()) stack.push(tempStack.pop());
                } else if (log == '-') {
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(log);
                }
            }

            for (char c : stack) {
                st.append(c);
            }
            while(!tempStack.isEmpty()){
                st.append(tempStack.pop());
            }
            System.out.println(st);
        }
    }}