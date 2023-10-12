import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int togo = N-1;
        int count = 1;
        while(togo > 0){
            togo -= 6 * (count-1);
            count++;
        }
        if(count == 1){
            System.out.println(1);
        } else{
            System.out.print(count-1);    
        }
        
    }

}