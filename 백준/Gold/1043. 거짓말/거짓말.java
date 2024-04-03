import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static boolean[] knowsTruth;
    static Queue<Integer> queue;
    static int[][] parties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //사람 수
        M = Integer.parseInt(st.nextToken()); //파티 수
        answer = M;
        knowsTruth = new boolean[N+1];
        queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for(int i=0; i<num; i++){
            int person = Integer.parseInt(st.nextToken());
            knowsTruth[person] = true;
            queue.add(person);
        }
        parties = new int[M][];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            parties[i] = new int[num];
            for(int j=0; j<num; j++){
                parties[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(!queue.isEmpty()){
            int person = queue.poll();
            for(int r=0; r<M; r++){
                if(parties[r] == null) continue;
                for(int c=0; c<parties[r].length; c++){
                    if(parties[r][c] == person){
                        for(int p : parties[r]){
                            if(!knowsTruth[p]){
                                queue.offer(p);
                                knowsTruth[p] = true;
                            }
                        }
                        parties[r] = null;
                        answer--;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}