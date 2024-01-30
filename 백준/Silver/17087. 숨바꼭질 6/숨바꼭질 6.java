import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N; //동생 수 (1~100000)
    static int S; // 수빈 첫 위치 (1~10억)
    static int[] dist; //떨어진 거리 배열
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        dist = new int[N];
        int min = Integer.MAX_VALUE;
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            dist[i] = Math.abs(Integer.parseInt(s[i])-S); //거리의 차 계산 후 저장
            if(dist[i] < min) min = dist[i];
        }

        //dist 배열 값들의 최대공약수 구하기.
        loop:
        for(int i=min; i>=2; i--){
            for(int j=0; j<dist.length; j++){
                if(dist[j] % i != 0) break;
                if(j == dist.length-1) {
                    answer = i;
                    break loop;
                }
            }
        }
        if(answer == 0) answer = 1;
        System.out.println(answer);
    }

}
