import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int H = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int C = sc.nextInt();
        H += C / 60;
        M += C % 60;
        if(M >= 60) {
            H++;
            M -= 60;
        }
        H %= 24;

        System.out.println(H + " " + M);
    }

}
