import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //자리수
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    //수를 이어붙이는 함수
    static void DFS(int num, int digit){
        if(digit == N){
            if(isPrime(num)){
                System.out.println(num);
            }
            return;
        } else{
            for(int i=1; i<10; i++){
                if(i%2 == 0){continue;} //짝수라면 탐색할 필요 없음.
                if(isPrime(num * 10 + i)){ //소수이면 자리수 하나를 더 늘림.
                    DFS(num*10+i, digit +1);
                }
            }
        }
    }

    static boolean isPrime(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}