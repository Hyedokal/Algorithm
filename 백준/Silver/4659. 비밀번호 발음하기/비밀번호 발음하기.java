import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
3. 같은 글자가 연속적으로 두 번 오면 안되나, ee 와 oo는 허용한다.
* */

public class Main {
    static ArrayList<Character> vowels = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String pw = br.readLine();
            if(pw.equals("end")) break;

            if(rule1(pw) && rule2(pw) && rule3(pw)){
                System.out.println("<"+pw+"> is acceptable.");
            } else {
                System.out.println("<"+pw+"> is not acceptable.");
            }
        }
    }

    static boolean rule1(String pw){
        char[] chars = pw.toCharArray();
        for(char ch : chars){
            if(ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u'){
                return true;
            }
        }
        return false;
    }

    static boolean rule2(String pw){
        int cStreak = 0;
        int vStreak = 0;
        char[] chars = pw.toCharArray();
        if(chars[0] == 'a' || chars[0] == 'e' || chars[0] == 'i' || chars[0] == 'o' || chars[0] == 'u'){
            vStreak++;
        } else cStreak++;
        for(int i=1; i<chars.length; i++){
            if(vowels.contains(chars[i-1]) && vowels.contains(chars[i])){
                vStreak++;
            } else if(vowels.contains(chars[i-1]) && !vowels.contains(chars[i])){
                vStreak = 0;
                cStreak++;
            } else if(!vowels.contains(chars[i-1]) && vowels.contains(chars[i])){
                cStreak = 0;;
                vStreak++;
            } else{
                cStreak++;
            }
            if(cStreak == 3 || vStreak == 3){
                return false;
            }
        }
        return true;
    }

    static boolean rule3(String pw){
        char[] chars = pw.toCharArray();
        for(int i=0; i<chars.length-1; i++){
            if(chars[i] == chars[i+1]){
                if (chars[i] != 'e' && chars[i] != 'o'){
                    return false;
                }
            }
        }
        return true;
    }
}