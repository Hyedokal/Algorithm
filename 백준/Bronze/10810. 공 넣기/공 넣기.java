import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];

        for(int x=0; x<M; x++){
            s = sc.nextLine().split(" ");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            Arrays.fill(arr, i-1, j, k);
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

}
