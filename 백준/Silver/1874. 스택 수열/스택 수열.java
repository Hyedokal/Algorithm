import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int num = 1;
        int index = 0; //수열의 인덱스
        Stack<Integer> stack = new Stack<>();
        while(true){
            if(index == arr.length) break;
            if(arr[index] > num){
                while(num <= arr[index]){
                    sb.append("+\n");
                    stack.push(num++);
                }
            }
            if(stack.isEmpty()) {
                if(num > n) break;
                sb.append("+\n");
                stack.push(num++);
            } else {
                if(stack.peek() == arr[index]){
                    while(stack.peek() == arr[index]){
                        stack.pop();
                        sb.append("-\n");
                        index++;
                        if(stack.isEmpty()) break;
                    }
                } else if(stack.peek() > arr[index]){
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                } else{
                    sb.append("+\n");
                    stack.push(num++);
                }
            }

        }
        System.out.println(sb);
    }
}