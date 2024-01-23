import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        long num = 1;
        while(true){
            long temp = num*num;
            if(temp > N) break;
            count++;
            num++;
        }
        System.out.println(count);
    }
}


