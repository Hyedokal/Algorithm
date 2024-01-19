import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj1456
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 받기 (두 수는 long)
        String[] s = br.readLine().split(" ");
        long A = Long.parseLong(s[0]);
        long B = Long.parseLong(s[1]);

        int M = (int) Math.sqrt(B); // [sqrt(B)] : 최대 10,000,000
        int[] nums = new int[M+1]; //0 ~ M까지의 수 저장
        for(int i=2; i<nums.length; i++){ //nums배열 초기화
            nums[i] = i;
        }

        //2 <= p <= M (가우스 루트 B) 사이 소수 찾기
        //에라토스테네스의 체 구현
        for(int i=2; i <= Math.sqrt(M); i++){
            if(nums[i] != 0){ //만약 아직 지워지지 않은 수라면..
                for(int j = i; i*j <= M; j++){
                    if(nums[i*j] != 0) nums[i*j] = 0; //아직 지워지지 않은 i의 배수들을 지운다.
                }
            }
        }

        int count = 0;
        for(int i=2; i<nums.length; i++){
            if(nums[i] != 0){ // i가 소수라면..
                for(int j=2; (long) Math.pow(i, j) <= B; j++){
                    // A <= 소수의 거듭제곱 <= B 갯수 세기
                    if(A <= (long) Math.pow(i, j)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}


