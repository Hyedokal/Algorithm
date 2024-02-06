import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        // 우선순위 map 생성
        Map<Character, Integer> prior = new HashMap<>();
        prior.put('(', 0);
        prior.put('+', 1);
        prior.put('-', 1);
        prior.put('*', 2);
        prior.put('/', 2);
        //후위 표기식을 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();
        // 연산자 stack 구현
        Stack<Character> op = new Stack<>();
        for(char ch : s){
            //숫자면 그냥 쓴다.
            if('A' <= ch && ch <= 'Z') sb.append(ch);
            else{ //연산자이면..
                if(op.isEmpty()) op.push(ch); //스택이 비어있으면 그냥 넣는다.
                else{
                    if(ch == '(') op.push(ch); // 여는 괄호는 그냥 넣는다.
                    else if (ch == ')') { //오른쪽 괄호면 왼쪽 괄호 나올때까지 push한다.
                        while(op.peek() != '(') sb.append(op.pop());
                        op.pop();//왼쪽 괄호는 그냥 버린다.
                    } else{ //사칙연산자일 때..
                        //지금 연산자가 우선순위가 더 높으면 그냥 넣는다.
                        if(prior.get(ch) > prior.get(op.peek())) {
                            op.push(ch);
                        } else{ // 지금 연산자의 우선순위가 같거나 더 낮으면, 더 낮은 연산자가 나올 때까지 pop
                            while(prior.get(op.peek()) >= prior.get(ch)) {
                                sb.append(op.pop());
                                if(op.isEmpty()) break;
                            }
                            //그리고 현재 연산자를 넣음.
                            op.push(ch);
                        }
                    }
                }
            }
        }
        while (!op.isEmpty()) sb.append(op.pop());
        System.out.println(sb);
    }
}
