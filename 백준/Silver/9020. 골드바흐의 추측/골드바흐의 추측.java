import java.util.Scanner;

public class Main {
    static int T, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        for(int t=0; t<T; t++){
            N = sc.nextInt();
            if(N==4) {
                sb.append(2).append(" ").append(2).append("\n");
                continue;
            }
            int num1, num2;
            if((N/2)%2==0){
                num1 = N/2-1;
                num2 = N/2+1;
            } else{
                num1 = N/2;
                num2 = N/2;
            }

            while(true){
                // 둘 다 소수이면..
                if(isPrime(num1)&&isPrime(num2)) {
                    sb.append(num1).append(" ").append(num2).append("\n");
                    break;
                }
                num1 -= 2;
                num2 += 2;
            }
        }
        System.out.println(sb);
    }
    //소수 판별
    static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }
}