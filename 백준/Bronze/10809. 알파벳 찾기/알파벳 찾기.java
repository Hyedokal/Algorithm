import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);
        for(int i=0; i<arr.length; i++){
            if(alphabets[arr[i]-97] == -1){
                alphabets[arr[i]-97] = i;
            }
        }
        for(int i : alphabets){
            System.out.print(i + " ");
        }
    }

}
