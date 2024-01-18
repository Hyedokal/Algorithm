import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] digits = br.readLine().split("");  //자릿수들을 String으로 저장
        ArrayList<Integer> answer = new ArrayList<>();
        int digitSum = 0;
        boolean checkZero = false; //0이 있나없나 확인
        for(String str : digits){
            int tmp = Integer.parseInt(str);
            answer.add(tmp);
            digitSum += tmp; //자릿수들의 합을 구한다.
            if(tmp == 0) checkZero = true;
        }
        if(digitSum % 3 == 0 && checkZero){ //30의 배수이면..
            //자릿수 정렬
            Collections.sort(answer);
            for(int i=answer.size()-1; i>=0; i--){
                System.out.print(answer.get(i));
            }
        } else System.out.println(-1);
    }
}


