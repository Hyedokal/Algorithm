import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split("");
        int answer = 0;
        for(int i=0; i<N; i++){
            answer += Integer.parseInt(s[i]);
        }
        System.out.println(answer);
    }

}
