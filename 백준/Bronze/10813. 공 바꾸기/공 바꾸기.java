import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        for(int i=0; i<M; i++){
            s = sc.nextLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int temp = 0;

            //공 바꾸기
            temp = arr[x-1];
            arr[x-1] = arr[y-1];
            arr[y-1] = temp;
        }
        for(int i  : arr) {
            System.out.print(i + " ");
        }
    }

}
