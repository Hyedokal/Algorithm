import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String answer = "Possible";
            String[] temp = br.readLine().split(" ");
            if(temp[0].length() != temp[1].length()){
                answer = "Impossible";
            }
            char[] word1 = temp[0].toCharArray();
            char[] word2 = temp[1].toCharArray();
            Arrays.sort(word1);
            Arrays.sort(word2);
            for(int k=0; k<word1.length; k++){
                if(word1[k] != word2[k]){
                    answer = "Impossible";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}