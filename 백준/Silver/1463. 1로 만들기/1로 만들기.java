import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Queue<Integer> queue;
    static int[] arr;
    static boolean[] visited;
    static int target;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        arr = new int[target+1];
        visited = new boolean[target];  // 0~target
        queue = new LinkedList<>();

        if(target > 1) {
            queue.offer(1);
            visited[1] = true;
            BFS();
        }
        System.out.println(arr[target]);
    }
    static void BFS(){
        while(true){
            if(arr[target] != 0) break;
            int now = queue.poll();
            if(now*3 <= target && arr[now*3] == 0) {
                arr[now*3] = arr[now]+1;
                queue.offer(now*3);
            }
            if(now*2 <= target && arr[now*2] == 0) {
                arr[now*2] = arr[now]+1;
                queue.offer(now*2);
            }
            if(now+1 <= target && arr[now+1] == 0) {
                arr[now+1] = arr[now]+1;
                queue.offer(now+1);
            }
        }
    }
}
