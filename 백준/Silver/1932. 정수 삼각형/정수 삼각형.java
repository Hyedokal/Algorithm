import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<s.length; j++){
                triangle[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int r=1; r<N; r++){
            for(int c=0; c<=r; c++){
                if(c==0) triangle[r][c] += triangle[r-1][c];
                else if(c==r) triangle[r][c] += triangle[r-1][c-1];
                else triangle[r][c] += Math.max(triangle[r-1][c-1], triangle[r-1][c]);
            }
        }
        int answer = 0;
        //for(int[] arr : triangle) System.out.println(Arrays.toString(arr));
        for(int i : triangle[N-1]) if(answer < i) answer = i;
        System.out.println(answer);
    }

}
