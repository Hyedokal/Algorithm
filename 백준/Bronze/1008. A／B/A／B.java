import java.util.Scanner;

public class Main {

    static int A;
    static int B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
        System.out.println((double)A/B);
    }

}
