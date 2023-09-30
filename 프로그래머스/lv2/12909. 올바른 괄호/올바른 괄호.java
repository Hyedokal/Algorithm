import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
            } else if(s.charAt(i) == ')' && stack.isEmpty()){
               return false;
            } 
        }
        
        return stack.isEmpty();
    }
}