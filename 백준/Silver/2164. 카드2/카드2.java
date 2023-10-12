import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> myList = new LinkedList<>();
        for(int i=0; i<N; i++){
            myList.add(i+1);
        }
        while(myList.size() != 1){
            myList.remove(0);
            int add = myList.get(0);
            myList.remove(0);
            myList.add(add);
        }
        System.out.print(myList.get(0));
    }
}