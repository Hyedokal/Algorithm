import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();   // 'X번째' 분수
        int sum = 0;
        int i=0;
        while(sum < X){ //sum이 X보다 작을 때까지..
            sum += i; //1+2+3+4+..
            i++;
        }
        //X보다 크거나 같아졌을 때의 i값이 N/M에서 N+M의 합.
        int temp = X+i-sum-1; //N+M=i인 분수들 중 답이 temp번째로 등장한다는 뜻.
        int N = 0;
        int M = 0;
        //i가 홀수일 경우
        if(i%2==1){
            N = temp;
            M = i - temp;

        } else{ //i 짝수
            M = temp;
            N = i - temp;
        }

        System.out.println(N+"/"+M);
    }

}
