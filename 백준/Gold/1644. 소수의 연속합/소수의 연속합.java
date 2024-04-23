import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, prime[], len, cnt;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        len = N-1; //소수 개수를 저장하는 변수
        isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        //idea: 에라토스테네스의 체로 N 이하의 소수를 모두 구한 뒤 투포인터.
        findPrime();
        prime = new int[len];
        int idx = 0;
        for(int i=2; i< isPrime.length; i++){
            if(isPrime[i]) prime[idx++] = i;
        }
        int start = 0;
        int end = 0;
        int tmp = 0;
        cnt = 0;
        while(start < prime.length && end < prime.length){
            tmp += prime[end];
            if(tmp >= N){
                if(tmp == N) cnt++;
                while(tmp >= N) {
                    tmp -= prime[start];
                    start++;
                    if(tmp == N) cnt++;
                }
            }
            end++;
        }
        System.out.println(cnt);
    }
    static void findPrime(){
        //에라토스테네스의 체 구현
        for(int i=2; i<=Math.sqrt(N); i++){
            if(!isPrime[i]) continue;
            for(int j=i*2; j<=N; j+=i) {
                if(isPrime[j]){
                    isPrime[j] = false;
                    len--;
                }
            }
        }
    }
}
