import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] miniBoard;
    static int N, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;
        miniBoard = new int[N];
        placeQueen(0);
        System.out.println(count);
    }

    //idx: miniBoard에 값을 저장할 인덱스
    static void placeQueen(int idx){
        if(idx == N) {
            count++;
            return;
        }
        //0~N-1까지 내가 놓을 수 있는 경우를 찾는다.
        loop:
        for(int i=0; i<N; i++){
            //찾는 방법: 이전까지 내가 놓은 퀸들의 위치를 본다.
            for(int j=0; j<idx; j++){
                // 놓을 수 없는가? 그러면 다음 열을 본다.
                if(miniBoard[j] == i || ((idx - j) == Math.abs(miniBoard[j]-i))) continue loop;
            }
            //놓을 수 있다면 재귀를 돌린다.
            miniBoard[idx] = i;
            placeQueen(idx+1);
        }
    }
}
