import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, answer;
    static int[] chooseArr; //모드 5개 선택하는 배열.
    static int[] target = {1,2,3,4};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int r=0; r<N; r++){
            String[] s = br.readLine().split(" ");
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(s[c]);
            }
        }
        answer = 0;
        chooseArr = new int[5]; //움직일 순서 저장하는 배열.
        nPIrAndMove(0); //중복순열로 순서를 정하고, 움직여 본다.
        System.out.println(answer);
    }

    //idea: 이 함수를 4(PI)5번 수행한다.
    static int[][] move(int[][] board, int mode){
        switch(mode) {
            //위로 몰기
            case 1:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index - 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 2:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 3:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index - 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //오른쪽으로 몰기
            case 4:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index + 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
        return board;
    }

    static void nPIrAndMove(int cnt){
        if(cnt == 5) {
            int[][] brd = new int[N][N];
            //deepcopy
            for(int r=0; r<N; r++) brd[r] = Arrays.copyOf(map[r], N);
            for(int i=0; i<chooseArr.length; i++){
                brd = move(brd, chooseArr[i]);
            }
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if (brd[r][c] > answer) answer = brd[r][c];
                }
            }
            return;
        }
        for(int i=0; i<4; i++){
            chooseArr[cnt] = target[i];
            nPIrAndMove(cnt+1);
        }
    }
}