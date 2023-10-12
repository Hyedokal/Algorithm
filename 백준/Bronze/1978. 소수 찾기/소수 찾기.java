import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int count = 0;
        for(String string : s){
            if(Findprime(string)){
                count++;
            }
        }

        System.out.print(count);
    }
    private static boolean Findprime(String s){
        int num = Integer.parseInt(s);
        if(num == 1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}