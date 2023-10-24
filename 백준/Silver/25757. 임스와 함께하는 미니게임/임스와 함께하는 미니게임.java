import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    static int target;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        String game = tmp[1];
        if(game.equals("Y")) target = 1;
        else if(game.equals("F")) target = 2;
        else target = 3;
        //같이 게임할 사람
        Set<String> members = new HashSet<>();
        //이미 같이 게임한 사람
        Set<String> already = new HashSet<>();
        int answer = 0;
        for(int i=0; i<N; i++){
            String id = br.readLine();
            if(already.contains(id)) continue;
            else{
                members.add(id);
                already.add(id);
            }
            if(members.size() == target){
                answer++;
                members.clear();
            }
        }
        System.out.print(answer);
    }
}