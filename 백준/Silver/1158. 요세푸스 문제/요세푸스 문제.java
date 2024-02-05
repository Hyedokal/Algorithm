import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0; i< list.length; i++) list[i] = i+1;
        StringBuilder sb = new StringBuilder("<");
        int index = 0;
        for(int i=0; i<N; i++){

            int count = 0;
            while(true){
                if (!visited[index]) {
                    count++; //넘어간 횟수를 센다
                    index++; //인덱스도 추가시킨다.
                    index %= N;
                    if(count == K) { //K번 건너뛰었으면
                        if(index>0) index--; //그 전 인덱스에 대해 작업 수행
                        else index = N-1;   // 현재 인덱스가 0일 경우, 그 전 인덱스는 맨 뒤
                        sb.append(list[index]);
                        sb.append(", ");
                        visited[index] = true;
                        break;
                    }
                }
                else {
                    index++;
                    index %= N;
                }
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
