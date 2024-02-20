import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char[] str = br.readLine().toCharArray();
        int pieces = 0;
        int sticks = 0;
        for(int i=0; i<str.length-1; i++){
            if(str[i]=='(' && str[i+1]==')'){ //레이저면
                pieces += stack.size();
                i++;
            } else{ //레이저 아닐 때
                if(str[i] == '(') {
                    stack.push(str[i]); //쇠막대기 추가
                    sticks++;
                }
                if(str[i] == ')') stack.pop(); //쇠막대기 끝남
            }
        }
        pieces += sticks;
        System.out.println(pieces);
    }
}
