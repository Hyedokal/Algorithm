import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            long sum = 0;
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int[] nums = new int[N];
            for(int j=0; j<N; j++){
                nums[j] = Integer.parseInt(s[j+1]); //숫자 배열 초기화
            }

            for(int x=0; x<nums.length-1; x++){
                for(int y=x+1; y<nums.length; y++){
                    //GCD 찾고 더하기
                    sum += GCD(nums[x], nums[y]);
                }
            }

            System.out.println(sum);



        }
    }

    static int GCD(int x, int y){
        int GCD = 1;
        int count = 2;
        while(count <= Math.min(x, y)){

            if(x % count == 0 && y % count == 0){
                GCD *= count;
                x /= count;
                y /= count;
                count = 2;
            } else count++;
        }
        return GCD;
    }
}


