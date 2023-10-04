import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] distance = new int[N+1][N+1];
        //인접 행렬 초기화
        for(int i=0; i<N+1; i++){
            for(int j=0; j<N+1; j++){
                if( i != j ){
                    distance[i][j] = 999999999;
                }
            }
        }
        //노선 정보 update
        for(int i=0; i<M; i++){
            String[] str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            int value = Integer.parseInt(str[2]);
            if(distance[start][end] > value){   //기존의 비용이 새로 들어온 비용보다 크면, 새로 들어온 비용으로 update.
                distance[start][end] = value;
            }
        }

        //플로이드-워셜 알고리즘 수행
        for(int k=1; k<N+1; k++){           //경유지 K
            for(int s=1; s<N+1; s++){       //출발지 S
                for(int e=1; e<N+1; e++){   //도착지 E
                    if (distance[s][e] > distance[s][k]+distance[k][e]){
                        distance[s][e] = distance[s][k]+distance[k][e];
                    }
                }
            }
        }
        //정답 출력
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(distance[i][j] == 999999999){
                    System.out.print(0 + " ");
                } else{
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
