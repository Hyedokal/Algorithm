import java.util.Scanner;

public class Main {
    static int A;
    static int B;
    static int V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
        V = Integer.parseInt(s[2]);
        int allDay = A - B;
        int answer;
        if((V-A) % allDay == 0) answer = (V-A)/allDay +1;
        else answer = (V-A)/allDay +2;
        System.out.print(answer);
    }

}