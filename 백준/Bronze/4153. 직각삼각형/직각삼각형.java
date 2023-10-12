import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] edges = br.readLine().split(" ");
            if(edges[0].equals("0")){
                break;
            }
            int[] lengths = new int[3];
            for(int i=0; i<3; i++){
                lengths[i] = Integer.parseInt(edges[i]);
            }
            Arrays.sort(lengths);
            if(Math.pow(lengths[0], 2) + Math.pow(lengths[1],2 ) == Math.pow(lengths[2], 2)){
                System.out.println("right");
            }else {
                System.out.println("wrong");
            }


        }
    }
}