import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long A,B,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        A = Long.parseLong(s[0]);
        B = Long.parseLong(s[1]);
        C = Long.parseLong(s[2]);
        System.out.println(pow(A, B, C));
    }

    //A^B를 C로 나눈 나머지
    static long pow(long A, long B, long C){
        long rest = A%C;
        if(B==0) return 1;
        if(B==1) return rest;
        long tmp = pow(rest, B/2, C);
        tmp = tmp*tmp%C;
        if(B%2 == 0) {
            return tmp%C;
        }
        else {
            return tmp*rest%C;
        }
    }
}