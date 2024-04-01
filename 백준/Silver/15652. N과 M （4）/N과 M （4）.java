import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//중복조합
public class Main {

    static int N, M, tmp;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[M];
        tmp = 0;
        H(1, 0);
        System.out.println(sb);
    }
    //중복 조합
    static void H(int n, int count){
        if(count==M){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        if(n>N) return;
            arr[count] = n;
            H(n, count+1);
            H(n+1, count);
    }
}