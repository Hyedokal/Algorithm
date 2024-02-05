import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int target = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] >= target) break;
            for(int j= i+1; j<arr.length; j++){
                if(arr[i]+arr[j] == target) count++;
                else if(arr[i]+arr[j] > target) break;
            }

        }
        System.out.println(count);
    }

}
