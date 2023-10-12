import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int twos = 0;
        int fives = 0;
        for(int i=1; i<=N; i++){
            twos += divideBy2(i, 0);
            fives += divideBy5(i, 0);
        }
        System.out.println(Math.min(twos, fives));
    }
    static int divideBy2(int N, int count){
        if(N % 2 != 0){
            return count;
        }else return divideBy2(N/2, count+1);
    }
    static int divideBy5(int N, int count){
        if(N % 5 != 0){
            return count;
        }else return divideBy5(N/5, count+1);
    }
}