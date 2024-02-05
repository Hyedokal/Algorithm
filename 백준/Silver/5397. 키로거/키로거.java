import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            char[] chars = br.readLine().toCharArray();
            for(int i=0; i<chars.length; i++){
                switch (chars[i]){
                    case '<':
                        if(!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if(!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if(!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(chars[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char ch : left) sb.append(ch);
            while(!right.isEmpty()) sb.append(right.pop());
            System.out.println(sb);
        }

    }
}
