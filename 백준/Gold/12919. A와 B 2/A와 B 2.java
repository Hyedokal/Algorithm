import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;
//    static StringBuilder sb;
    static int isChangable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isChangable = 0;
        StringBuilder sb = new StringBuilder();
        S = br.readLine();
        T = br.readLine();
        sb.append(T);
        recur(sb, false, 0);
        System.out.println(isChangable);


    }
    //1. 문자열 뒤에 A를 뺀다.
    //2. 문자열 앞에 B를 빼고, 문자열을 뒤집는다.
    static void recur(StringBuilder sb, boolean isReversed, int depth){
       //base case
        if(sb.length() < S.length()) return;
        if(sb.length() == S.length()) {
            String tmp = sb.toString();
            StringBuilder sb2 = new StringBuilder(tmp);
            if(isReversed){
               sb2.reverse();
            }
            if(S.contentEquals(sb2)) isChangable = 1;
            return;
        }

        if(!isReversed){
            //T 맨 앞글자가 B라면..
            if(sb.charAt(0)=='B'){
                sb.deleteCharAt(0);
                recur(sb, true, depth+1);
                sb.insert(0, 'B');
            }
            //맨 뒤에 A가 있으면 1번을 실행한 문자열일 수 있다.
            if(sb.charAt(sb.length()-1)=='A'){
                sb.deleteCharAt(sb.length()-1);
                recur(sb, false, depth+1);
                sb.append('A');
            }
        } else{ //이미 뒤집어져 있는 문자열인 경우..
            //T 맨 앞글자가 B라면..
            if(sb.charAt(sb.length()-1)=='B'){
                sb.deleteCharAt(sb.length()-1);
                recur(sb, false, depth+1);
                sb.append('B');
            }
            //맨 뒤에 A가 있으면 1번을 실행한 문자열일 수 있다.
            if(sb.charAt(0)=='A'){
                sb.deleteCharAt(0);
                recur(sb, true, depth+1);
                sb.insert(0, 'A');
            }
        }
    }
}