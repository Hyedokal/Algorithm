import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        int temp = N;
        for(int i=2; i<= N; i++){
            while(temp % i == 0){
                temp /= i;
                System.out.println(i);
            }
            if(temp == 1) break;
        }
    }

}
