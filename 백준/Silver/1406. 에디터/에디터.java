import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        char[] chars = br.readLine().toCharArray();
        for(char ch : chars) left.push(ch);
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            String s = br.readLine();
            switch (s){
                case "L":
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty()) left.pop();
                    break;
                default:
                    left.push(s.charAt(2));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : left) sb.append(ch);
        while(!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}
