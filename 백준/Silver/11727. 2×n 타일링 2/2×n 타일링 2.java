import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        arr[1] = 1;
        if(N > 1) arr[2] = 3;
        for(int i=3; i<arr.length; i++){
            int sN = arr[i-1] + 2*arr[i-2];
            if(sN >= 10007) arr[i] = sN%10007;
            else arr[i] = sN;
        }
        System.out.println(arr[N]);
    }


}