import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T; //테케 개수
    static int K; //층 수
    static int N; //호 수
    //아이디어: 2차원 배열로 처리.
    static int[][] apt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        apt = new int[15][15];
        for(int i=0; i<15; i++){    //0층 초기화
            apt[0][i] = i;
        }
        for(int i=1; i<15; i++){    //1~14층 초기화
            for(int j=1; j<15; j++){
                apt[i][j] = apt[i-1][j]+apt[i][j-1];
            }
        }
        for(int i=0; i<T; i++){
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            System.out.println(apt[K][N]);
        }
    }
}