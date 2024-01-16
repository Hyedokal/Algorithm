import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        //방 번호 자릿수 배열
        int[] digits = new int[s.length];
        //방 번호에 들어있는 숫자 개수 배열 (인덱스 10: 숫자 6, 9 개수 합)
        int[] count = new int[11];
        for(int i=0; i<s.length; i++){
            digits[i] = Integer.parseInt(s[i]);
            count[digits[i]]++;
        }

        count[10] = (int) (Math.ceil((double)(count[6] + count[9]) / 2));
        count[6] = 0;
        count[9] = 0;
        int max = 0;
        for(int num : count){
            if(num>max) max = num;
        }

        System.out.println(max);

    }

}
