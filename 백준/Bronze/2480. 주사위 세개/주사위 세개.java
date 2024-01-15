import java.util.Scanner;

public class Main{


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int C = Integer.parseInt(s[2]);

        if(A == B && B == C){
            System.out.println(10000 + A*1000);
        } else if(A != B && B != C && C != A){
            System.out.println(100 * Math.max(A, Math.max(B, C)));
        } else{
            if(A == B || A == C) System.out.println(1000 + A * 100);
            else System.out.println(1000 + B * 100);
        }
    }
}