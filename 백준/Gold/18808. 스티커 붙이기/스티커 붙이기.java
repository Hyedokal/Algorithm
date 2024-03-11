import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M, K, R, C, answer;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 노트북 세로길이
        M = Integer.parseInt(s[1]); // 노트북 가로길이
        K = Integer.parseInt(s[2]); // 스티커 개수
        map = new int[N][M];
        answer = 0;
        for(int k=0; k<K; k++){
            s = br.readLine().split(" ");
            R = Integer.parseInt(s[0]);
            C = Integer.parseInt(s[1]);
            int[][] sticker = new int[R][C];
            for(int r=0; r<R; r++){
                s = br.readLine().split(" ");
                for(int c=0; c<C; c++){
                    sticker[r][c] = Integer.parseInt(s[c]);
                }
            }
            post(sticker);
        }
        System.out.print(answer);
    }

    //스티커 붙이는 메서드
    static void post(int[][] sticker){
        int rot = 0;
        //돌려가며 붙여보자.
        rotateLoop:
        while(rot < 4) {
            int[][] newSticker = rotate(sticker, rot);
            boolean possible = false;

            for(int r=0; r<N; r++){ //map 배열의 반복문
                mapLoop:
                for(int c=0; c<M; c++){
                    stickerLoop: //스티커를 붙일 수 있는 지 확인한다.
                    for (int x = 0; x < newSticker.length; x++) {
                        for (int y = 0; y < newSticker[0].length; y++) {
//                            System.out.println("r: " + r + " c: " + c + " x: " + x + " y: " + y);
                            if (newSticker[x][y] == 0) {
                                //마지막 칸까지 왔는데, 얘가 0이면 붙일수 있다는 의미
                                if(x == (newSticker.length - 1) && y == (newSticker[0].length - 1)){
                                    possible = true;
                                }
                                continue;
                            }
                            //해당 칸 값이 1일 때, 유효성 확인
                            if (0 <= (r + x) && (r + x) < N && 0 <= (c + y) && (c + y) < M) {
                                //못 붙이면 한칸 더 가봐
                                if (map[r + x][c + y] == 1) {
//                                    System.out.println("이미 붙어있음");
                                    continue mapLoop;
                                }
                                if(x == (newSticker.length - 1) && y == (newSticker[0].length - 1)){
                                    possible = true;
                                }
                            } else continue mapLoop;

                        }
                    }
                    //통과했으면 붙인다.
                    if (possible) {
                        for (int x = 0; x < newSticker.length; x++) {
                            for (int y = 0; y < newSticker[0].length; y++) {
                                if (newSticker[x][y] == 1) {
                                    map[r + x][c + y] = 1;
                                    answer++;
                                }
                            }
                        }
//                        for(int l=0; l<N; l++) System.out.println(Arrays.toString(map[l]));
//                        System.out.println("==================");
                        break rotateLoop;
                    }
                }
            }
            rot++;
        }

    }

    static int[][] rotate(int[][] sticker, int degree){
        int r = sticker.length;
        int c = sticker[0].length;
        int[][] newSticker;
        if(degree % 2 == 0) newSticker = new int[r][c];
        else newSticker = new int[c][r];

        switch (degree){
            case 0:
                return sticker;
            case 1:
                for(int x=0; x<r; x++){
                    for(int y=0; y<c; y++){
                        newSticker[y][r-1-x] = sticker[x][y];
                    }
                }
                return newSticker;
            case 2:
                for(int x=0; x<r; x++){
                    for(int y=0; y<c; y++){
                        newSticker[x][y] = sticker[r-x-1][c-y-1];
                    }
                }
                return newSticker;
            default:
                return rotate(rotate(sticker, 1), 2);
        }
    }
}