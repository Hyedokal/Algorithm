import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int participants = A * B;
        s = br.readLine().split(" ");
        int[] temp = new int[5];
        for(int i=0; i<5; i++){
            temp[i] = Integer.parseInt(s[i]) - participants;
            System.out.print(temp[i] + " ");
        }

    }

}
