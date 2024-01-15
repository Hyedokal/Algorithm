import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sang = Integer.parseInt(br.readLine());
        int joong = Integer.parseInt(br.readLine());
        int ha = Integer.parseInt(br.readLine());
        int coke = Integer.parseInt(br.readLine());
        int cidar = Integer.parseInt(br.readLine());
        System.out.println(Math.min(sang, Math.min(joong, ha)) + Math.min(coke, cidar)-50);
    }

}
