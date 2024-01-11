import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int T;
    static Stack<String> stack;
    static boolean valid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            test(br.readLine());
        }
    }
    public static void test(String vps){
        valid = true;
        stack.clear();
        String[] ps = vps.split("");
        for(int i=0; i<ps.length; i++){
            if(stack.empty() && ps[i].equals("(")){
                stack.push(ps[i]);
            } else if(stack.empty() && ps[i].equals(")")){
                valid = false;
                break;
            }else if(stack.peek().equals("(") && ps[i].equals(")")){
                stack.pop();
            } else{
                stack.push(ps[i]);
            }
        }
        if(!valid || !stack.empty()) System.out.println("NO");
        else System.out.println("YES");
    }
}
