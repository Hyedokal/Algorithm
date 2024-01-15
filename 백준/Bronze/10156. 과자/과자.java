import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int answer = a1 * a2 - a3;
        if(answer<0) answer = 0;
        System.out.println(answer);
    }

}
