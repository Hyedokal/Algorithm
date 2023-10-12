import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int H;   //행 개수
    static int W;   //열 개수
    static int N;   //세로줄 번호 띄우기
    static int M;   //가로줄 번호 띄우기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        H = Integer.parseInt(s[0]);
        W = Integer.parseInt(s[1]);
        N = Integer.parseInt(s[2]);
        M = Integer.parseInt(s[3]);

        int row = 0;
        int column = 0;
        if(H%(N+1) != 0){
            row = H/(N+1) +1;
        }else {
            row = H/(N+1);
        }
        if(W%(M+1) != 0){
            column = W/(M+1) +1;
        }else {
            column = W/(M+1);
        }
        System.out.println(row * column);
    }

}