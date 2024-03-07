import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static boolean[] isPrime;
    static List<Integer> primes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[110];
        isPrime = new boolean[110];
        for(int i=1; i<nums.length; i++){
            nums[i] = i;
        }
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        primes = new ArrayList<>();
        findPrime();
        for(int i=0; i<primes.size()-1; i++){
            int tmp = primes.get(i) * primes.get(i+1);
            if(primes.get(i) * primes.get(i+1) > N){
                System.out.print(tmp);
                break;
            }
        }
    }
    static void findPrime(){
        for(int i=0; i<55; i++){
            if(isPrime[i]){
                for(int j=2*nums[i]; j<nums.length; j+=nums[i]){
                    isPrime[j] = false;
                }
            }
        }
        for(int i=0; i< nums.length; i++){
            if(isPrime[i]) primes.add(i);
        }
    }
}