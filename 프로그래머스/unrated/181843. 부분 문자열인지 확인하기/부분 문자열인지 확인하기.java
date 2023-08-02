class Solution {
    public int solution(String my_string, String target) {
        int answer = 0;
        for(int i=0; i<my_string.length(); i++){
            if(my_string.substring(i).startsWith(target)){
                answer = 1;
                break;
            }
        }
        return answer;
    }
}