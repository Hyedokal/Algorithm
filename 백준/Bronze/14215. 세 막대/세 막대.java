import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] len = new int[3];
        for(int i=0; i<3; i++){
            len[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(len);
        if(len[0]+len[1] > len[2]) System.out.println(len[0]+len[1]+len[2]);
        else System.out.println((len[0]+len[1])*2-1);
    }

}
