import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> restSet = new HashSet<>();
        for(int i=0; i<10; i++){
            int temp = sc.nextInt() % 42;
            restSet.add(temp);
        }
        System.out.println(restSet.size());
    }

}
