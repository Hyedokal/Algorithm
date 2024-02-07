import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 파싱작업을 생략하기 위해 String[] 배열 생성
        String[] queue = new String[T]; //배열로 큐 구현
        int start = 0; //시작인덱스
        int end = 0; //끝인덱스
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            String[] s = br.readLine().split(" ");
            switch (s[0]){
                case "front":
                    if(start == end) sb.append(-1).append("\n");
                    else sb.append(queue[start]).append("\n");
                    break;
                case "back":
                    if(start == end) sb.append(-1).append("\n");
                    else sb.append(queue[end-1]).append("\n");
                    break;
                case "empty":
                    if(start == end) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "pop":
                    if(start == end) sb.append(-1).append("\n");
                    else sb.append(queue[start++]).append("\n");
                    break;
                case "size":
                    sb.append(end - start).append("\n");
                    break;
                default: //push X
                    queue[end++] = s[1];
            }
        }
        System.out.println(sb);
    }
}