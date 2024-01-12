import java.util.Scanner;

public class Main{

    static int L;
    static int P;
    static int V;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = 1;
        int sum = 0;
        while(true){
            String[] s = sc.nextLine().split(" ");
            L = Integer.parseInt(s[0]);
            if(L == 0) break;
            P = Integer.parseInt(s[1]);
            V = Integer.parseInt(s[2]);
            //우선 P일 간 모두 L일을 쓸 경우의 사용가능한 날 수를 더한다.
            sum += (V/P)*L;
            //이후 나머지 날짜 생각
            sum += Math.min(V%P, L);
            System.out.println("Case " + testCase + ": " + sum);
            sum = 0;
            testCase++;
        }


    }

}