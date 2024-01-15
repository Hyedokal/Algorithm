import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        if(M - 45 < 0){
            H--;
            M += 15;
            if(H == -1) H = 23;
        } else{
            M -= 45;
        }
        System.out.println(H + " " + M);
    }

}
