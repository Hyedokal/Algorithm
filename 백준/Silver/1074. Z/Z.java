import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, R, C, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        R = Integer.parseInt(s[1]);
        C = Integer.parseInt(s[2]);
        count = 0;
        //idea: 재귀를 하면서 4등분을 해 나간다.
        //i 번째 사각형에 있냐에 따라 (2^(n-k)*2^(n-k)*(i-1))를 더해 나간다.
        //k=n-1까지 재귀를 거치면 답이 나온다.
        recur(R, C, 1);
        System.out.println(count);
    }

    static void recur(int r, int c, int k){
        int half = (int) Math.pow(2, N-k);
        if(half <= 1) { //2x2 사각형까지 쪼갰다면..
            //몇 번째에 도달하는 지를 더해 준다.
            if(r==0&&c==1) count++;
            if(r==1&&c==0) count += 2;
            if(r==1&&c==1) count += 3;
            return;
        }
        //1번째
        if(0 <= r && r<half && 0 <= c && c<half){
            count += (int)(Math.pow(2, N-k)*Math.pow(2, N-k)*0);
            recur(r, c, k+1);
        }
        //2번째
        else if(0 <= r && r<half && half <= c && c<2*half){
            count += (int)(Math.pow(2, N-k)*Math.pow(2, N-k)*1);
            recur(r, c-half, k+1);
        }
        //3번째
        else if(half <= r && r<2*half && 0 <= c && c<half){
            count += (int)(Math.pow(2, N-k)*Math.pow(2, N-k)*2);
            recur(r-half, c, k+1);
        }
        //4번째
        else{
            count += (int)(Math.pow(2, N-k)*Math.pow(2, N-k)*3);
            recur(r-half, c-half, k+1);
        }
    }
}