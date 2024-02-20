import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        while(true){
            stack.clear();
            boolean flag = true;
            char[] chars = br.readLine().toCharArray();
            if(chars.length==1 && chars[0] == '.') break;
            for(char ch : chars){
                if(ch != '[' && ch != ']' && ch != '(' && ch != ')') continue;
                if(stack.isEmpty()){
                    if((ch == ')' || ch == ']')){
                        System.out.println("no");
                        flag = false;
                        break;
                    } else stack.push(ch);
                } else{
                    if(stack.peek() == '('){
                        if (ch == ')') stack.pop();
                        else if (ch == ']') {
                            System.out.println("no");
                            flag = false;
                            break;
                        } else stack.push(ch);
                    } else if(stack.peek() == '['){
                        if (ch == ']') stack.pop();
                        else if(ch == ')') {
                            System.out.println("no");
                            flag = false;
                            break;
                        }
                        else stack.push(ch);
                    }
                }
            }
            if(flag && !stack.isEmpty()) System.out.println("no");
            else if (flag) System.out.println("yes");
        }
    }
}
