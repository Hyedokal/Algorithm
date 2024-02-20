import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            char[] function = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            boolean isReversed = false; //뒤집어져 있는지 여부를 판단
            String str = br.readLine();
            if(str.length()>2){
                str = str.substring(1, str.length()-1);
                String[] s = str.split(",");
                str = "";
                for(String num : s){
                    deque.offer(Integer.parseInt(num)); //덱에 정수 넣기
                }
            }
            for(char ch : function){
                if (ch == 'R'){ //R이면 뒤집기
                    isReversed = !isReversed;
                }
                else if(ch == 'D' && !isReversed){ //안 뒤집어져 있고 D이면..
                    if(deque.isEmpty()) {
                        str = "error";
                        System.out.println("error");
                        break;
                    }
                    deque.pollFirst();
                } else { //뒤집어져 있고 D이면..
                    if(deque.isEmpty()) {
                        str = "error";
                        System.out.println("error");
                        break;
                    }
                    deque.pollLast();
                }
            }
            if(str.equals("error")) continue;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(!isReversed){
                while(!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                    sb.append(',');
                }
            } else{
                while(!deque.isEmpty()){
                    sb.append(deque.pollLast());
                    sb.append(',');
                }
            }
            if(sb.charAt(sb.length()-1) == ',') sb.deleteCharAt(sb.length()-1);
            sb.append("]");
            System.out.println(sb);
        }
    }
}
