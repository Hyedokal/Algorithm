import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N; //노드 개수
    static int E; //에지 개수
    static ArrayList<Integer>[] myList; //인접 리스트
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        myList = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            myList[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        for(int i=0; i<E; i++){
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            myList[start].add(end);
            myList[end].add(start);
        }
        count = 0;
        DFS(1);
        System.out.println(count-1);
    }
    static void DFS(int i){
        if(visited[i]){
            return;
        }
        count++;
        visited[i] = true;
        for(int num : myList[i]){
            if(!visited[num]){
                DFS(num);
                //visited[num] = true;
            }
        }
    }

}