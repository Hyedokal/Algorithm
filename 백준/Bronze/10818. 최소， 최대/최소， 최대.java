import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for(int i = 0; i<s.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[0] + " " +  arr[arr.length-1]);
    }

}
