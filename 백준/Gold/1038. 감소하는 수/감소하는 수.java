import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N > 1022) System.out.println(-1);
        else if (N<10) System.out.println(N);
        else{
            //자리수 구하기
            int digit = 1;
            while(true){
                int tmp = N - nCk(10, digit);
                if(tmp < 0) {
                    break;
                }
                N = tmp;
                digit++;
            }
            N++;
            //System.out.println("digit: " + digit + ", " + "N: " + N);
            int[] answer = new int[digit];
            //각 자리수별로 숫자 기록할거다.
            for(int i=0; i<digit-1; i++){
                int count = digit-i-1;
                //각 자리수에 들어갈 숫자 구하기
                while(true){
                    int tmp = N - nCk(count, digit-i-1);
                    if(tmp <= 0) break;
                    N = tmp;
                    count++;
                }
                answer[i] = count;
                //System.out.println("idx: " + i + ", " + "count: " + count + ", " + "N: " + N);
            }
            answer[digit-1] = N-1;
            for(int i:answer) System.out.print(i);
        }
    }

    static int nCk(int n, int k){
        if(k==0 || k==n || n==0) return 1;
        int m = Math.min(k, n-k);
        //System.out.println("n: "+n+" m: "+m);
        return nCk(n-1, m-1)+nCk(n-1, m);
    }
}