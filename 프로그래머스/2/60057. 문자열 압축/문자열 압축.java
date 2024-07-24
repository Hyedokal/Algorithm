import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 999999;
        int length = s.length();
        Stack<String> stack = new Stack<>();
        //자를 단어 길이
        for(int i=1; i<length; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int lastIdx = 0;
            for(int j=0; (j+1)*i <= length; j++){
                String str = s.substring(j*i, (j+1)*i);
                lastIdx = (j+1)*i;
                //비어있으면 스택에 넣는다.
                if(stack.isEmpty()) stack.push(str);
                else{
                    //이전 것과 같으면 안넣고 개수 추가.
                    if(stack.peek().equals(str)){
                        count++;
                    } else{ // 이전 것과 다르면 이전 것을 빼고 새로 넣는다.
                        if(count > 1){
                            sb.append(count).append(stack.pop());
                        } else{
                            sb.append(stack.pop());
                        }
                        stack.push(str);
                        count = 1;    
                    }
                }
            }
            //아직 못빠져 나온 것도 넣는다.
            while(!stack.isEmpty()) {
                if(count > 1){
                    sb.append(count).append(stack.pop());    
                } else sb.append(stack.pop());
                
            }   
            // System.out.println("i= " + i + ", sb= "+sb+", rest= " + (length-lastIdx));
            if(answer > sb.length()+(length-lastIdx)) 
                answer = sb.length()+(length-lastIdx);
        }
        if(s.length() == 1) answer = 1;
        return answer;
    }
}