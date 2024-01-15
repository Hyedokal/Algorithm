import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int[] sciScores = new int[4];
        int[] socScores = new int[2];
        for(int i=0; i<4; i++){
            sciScores[i] = sc.nextInt();
        }
        Arrays.sort(sciScores);
        for(int i=1; i<4; i++){
            answer += sciScores[i];
        }
        for(int i=0; i<2; i++){
            socScores[i] = sc.nextInt();
        }
        answer += Math.max(socScores[0], socScores[1]);
        System.out.println(answer);
    }

}
