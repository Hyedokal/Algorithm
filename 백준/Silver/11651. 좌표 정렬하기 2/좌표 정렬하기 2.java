import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            nodes[i] = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Arrays.sort(nodes);
        for(Node n : nodes) System.out.println(n.x + " " + n.y);
    }

    static class Node implements Comparable{
        int x;
        int y;

        Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Object o) {
            if(o instanceof Node){
                Node n = (Node) o;
                if(this.y == n.y){
                    return this.x - n.x;
                } else return this.y - n.y;
            }
            return 0;
        }
    }
}
