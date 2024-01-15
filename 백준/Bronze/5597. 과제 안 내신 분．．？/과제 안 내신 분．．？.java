import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] students = new int[31];
        for(int i=0; i<31; i++){
            students[i] = i;
        }
        for(int i=0; i<28; i++){
            int submitted = sc.nextInt();
            students[submitted] = 0;
        }

        for(int i : students){
            if(i != 0) System.out.println(i);
        }
    }

}
