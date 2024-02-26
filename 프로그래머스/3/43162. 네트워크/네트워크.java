class Solution {
    static int answer;
    static boolean[][] visited;
    static int[][] graph;
    static int size;
    public int solution(int n, int[][] computers) {
        answer = 0;
        size = n;
        visited = new boolean[n][n];
        graph = new int[n][n];
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                graph[r][c] = computers[r][c];
            }
        }
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(!visited[r][c] && graph[r][c] == 1) {
                    answer++;
                    DFS(r, c);
                }
            }
        }
        return answer;
    }
    static void DFS(int r, int c){
       
        visited[r][c] = true;
        visited[c][r] = true;
        for(int k=0; k<size; k++){
            if(graph[r][k] == 1 && !visited[r][k]){
                DFS(r, k);
            }
        }
        for(int k=0; k<size; k++){
            if(graph[k][c] == 1 && !visited[k][c]){
                DFS(k, c);
            }
        }
    }
}