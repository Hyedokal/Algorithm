import java.util.Scanner;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        System.out.print(fact(N) / (fact(K) * fact(N-K)));
    }

    private static int fact(int i){
        if(i==1 || i == 0) return 1;
        return i * fact(i-1);
    }
}