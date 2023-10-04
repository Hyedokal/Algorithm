import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] results = new int[N+1]; //결과들을 저장할 배열.
        results[0] = 1;
        results[1] = 1;
        if(N == 1){
            System.out.print(1);
        } else{
            for(int i=2; i<N+1; i++){
                results[i] = (results[i-1]+results[i-2]) % 10007;
            }
            System.out.print(results[N]);
        }
        sc.close();
    }
}