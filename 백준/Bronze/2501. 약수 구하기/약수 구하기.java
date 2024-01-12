import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        List<Integer> divisors = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(N % i == 0){
                divisors.add(i);
            }
        }
        if(divisors.size()<K){
            System.out.println(0);
        }else System.out.println(divisors.get(K-1));
    }

}
