import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String space = " ";
        String star = "*";
        for(int i = 1; i<=N; i++){

            System.out.println(space.repeat(N-i) + star.repeat(i));
        }

    }
}