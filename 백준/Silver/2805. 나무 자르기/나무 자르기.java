import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]); //나무의 수
        int M = Integer.parseInt(temp[1]); //원하는 나무의 길이 합
        int[] trees = new int[N];
        temp = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(trees);
        int height = trees[N-1];
        int sum = 0;
        while(sum < M){
            height--;
            sum = 0;
            for(int k=N-1; k>=0; k--){
                if(trees[k] - height > 0){
                    sum += trees[k] - height;
                } else break;
            }

        }
        System.out.print(height);
    }
}