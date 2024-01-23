import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int E = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);
        int M = Integer.parseInt(s[2]);
        int i=0;
        int answer;
        while(true){
            answer = 28 * i + (S-1);
            if(answer % 15 == E-1 && answer % 19 == M-1){
                break;
            }
            i++;
        }
        System.out.println(answer+1);
    }
}


