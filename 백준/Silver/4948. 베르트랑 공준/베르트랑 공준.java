import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if(n==0) break;
            //n<= prime <= 2n 인 소수 개수 구하기
            findPrime(2*n);
        }
    }
    // n< prime <= 2n 인 소수 갯수를 출력하는 메서드.
    static void findPrime(int n){
        int count = 0;
        //에라토스테네스의 체 구현
        boolean[] isNotPrime = new boolean[n+1]; //0 ~ n
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i=2; i<=n; i++){
            if(!isNotPrime[i]) { //i가 소수이면..
                if(i > n/2 && i <= n) count++;
            }
            for(int j=2; j*i<=n; j++){
                isNotPrime[i*j] = true; //i의 배수를 모두 합성수로 판단.
            }
        }
        System.out.println(count);
    }
}
