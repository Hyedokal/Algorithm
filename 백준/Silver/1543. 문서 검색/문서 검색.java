import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String target = sc.nextLine();
        int count = 0;
        for(int i=0; i<=doc.length()-target.length(); i++){
            if(doc.substring(i, i+target.length()).equals(target)){
                count++;
                i += target.length()-1;
            }
        }
        System.out.println(count);
    }
}
