import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, X, Y, T, year, gcd, lcm;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        //idea: <x:y> = <year%M : year%N>이고, year를 구하는 문제.
        //      종말의 날 = M, N의 최소공배수
        for(int t=0; t<T; t++){
            year = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            int times = 0;
            gcd = GCD(M, N);
            lcm = M * N / gcd;
            //연도 후보 넣기
            int y1, y2;
            while(true){
                y1 = M*times+X;
                y2 = N*times+Y;
                if(y1 > lcm && y2 > lcm) break;
                if(y1 <= lcm) q1.offer(y1);
                if(y2 <= lcm) q2.offer(y2);
                times++;
            }
            //값 비교해서 같으면 break, 다르면 더 작은 쪽을 제거해나가며 비교
            while(!q1.isEmpty() && !q2.isEmpty()){
                if(q1.peek().equals(q2.peek())){
                    year = q1.poll();
                    break;
                }
                if(q1.peek() > q2.peek()) q2.poll();
                else q1.poll();
            }
            if(year == 0) year = -1;
            System.out.println(year);
        }
    }
    //최대공약수 구하는 함수
    static int GCD(int M, int N){
        //유클리드 호제법
        int max = Math.max(M, N);
        int min = Math.min(M, N);
        while(true){
            int rest = max % min;
            if(rest == 0) return min;
            max = min;
            min = rest;
        }
    }

}