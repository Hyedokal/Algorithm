import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테케 수
        for(int t=0; t<T; t++){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken()); //출발점 좌표
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken()); //도착점 좌표

            int N = Integer.parseInt(br.readLine()); //행성계 수
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken()); //중심 좌표
                int cr = Integer.parseInt(st.nextToken()); //반지름

                //출발점은 내부에 있고
                if( (Math.pow(x1-cx, 2) + Math.pow(y1-cy, 2) < Math.pow(cr, 2)) ){
                    //도착점은 외부에 있을 경우
                    if( (Math.pow(x2-cx, 2) + Math.pow(y2-cy, 2) > Math.pow(cr, 2)) ){
                        count++;
                    }
                } else if ((Math.pow(x2-cx, 2) + Math.pow(y2-cy, 2) < Math.pow(cr, 2))) { //반대의 경우도
                    if((Math.pow(x1-cx, 2) + Math.pow(y1-cy, 2) > Math.pow(cr, 2))){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
