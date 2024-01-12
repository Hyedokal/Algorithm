import java.util.Scanner;

public class Main{

    static int N;
    static int K;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        int count = 0;
        //2부터 N까지 모든 정수 적기
        int[] ints = new int[N-1];
        for(int i=2; i<=N; i++){
            ints[i-2] = i;
        }
        boolean[] erased = new boolean[N-1];

        loop:
        for(int i=0; i<ints.length; i++){
            for(int j=i; j<ints.length; j++){
                if(ints[j] % ints[i] == 0 && !erased[j]){
                    erased[j] = true;
                    count++;
                    if(count == K) {
                        System.out.println(ints[j]);
                        break loop;
                    }
                }
            }
        }
    }

}