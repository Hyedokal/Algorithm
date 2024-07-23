import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int J = Integer.parseInt(s[0]);
        int I = Integer.parseInt(s[1]);
        //준성이 무효
        if(J != 0 && J != 2 && J != 5){
            if(I == 0 || I == 2 || I == 5){
                System.out.println("<");
            } else{
                System.out.println("=");
            }
            //준성이 가위/바위/보...
        } else {
            //익준이 무효..
            if(I != 0 && I != 2 && I != 5){
                System.out.println(">");
                //익준이 무효 X
            } else{
                if(J == 0){
                    if(I == 0){
                        System.out.println("=");
                    } else if(I == 2){
                        System.out.println(">");
                    } else {
                        System.out.println("<");
                    }
                } else if(J==2){
                    if(I == 0){
                        System.out.println("<");
                    } else if(I == 2){
                        System.out.println("=");
                    } else {
                        System.out.println(">");
                    }
                } else{
                    if(I == 0){
                        System.out.println(">");
                    } else if(I == 2){
                        System.out.println("<");
                    } else {
                        System.out.println("=");
                    }
                }
            }
        }
    }
}
