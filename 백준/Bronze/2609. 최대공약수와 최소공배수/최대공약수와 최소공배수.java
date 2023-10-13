import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int LCM; //최소공배수
    static int GCD; //최대공약수
    static int Smaller;
    static ArrayList<Integer> Primes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int A = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);
        Smaller = Math.min(A, B);
        LCM = 1;
        GCD = 1;
        //최대공약수 구하기 - A, B가 서로소가 될 때까지 나누기
        Primes = getPrimes(Smaller);
        for(int i : Primes){
            while(true){
                //둘 중 하나가 더 이상 나눠지지 않으면..
                if(A % i != 0 || B % i != 0){
                    break;
                } else {
                    GCD *= i;
                    A /= i;
                    B /= i;
                }
            }
        }
        LCM = GCD * A * B;

        System.out.println(GCD);
        System.out.print(LCM);
    }

    //N 이하의 소수들을 모두 담은 AL을 리턴하는 메서드.
    static ArrayList<Integer> getPrimes(int N){
        Primes = new ArrayList<>();
        for(int i=2; i<=N; i++){
            if(isPrime(i)){
                Primes.add(i);
            }

        }
        return Primes;
    }
    static boolean isPrime(int i){
        for(int k=2; k<=Math.sqrt(i); k++){
            if(i%k == 0){
                return false;
            }
        }
        return true;
    }
}