class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
        	int divider = 0;
        	//i의 제곱근이 자연수라면...
    		if(Math.sqrt(i) - Math.floor(Math.sqrt(i)) == 0) {
    			divider++;
    		}
        	for(int j=1; j < Math.sqrt(i); j++) {
        		if(i % j == 0) {
        			divider += 2;
        		} 
        		if(divider > limit) {
            		divider = power;
            		break;
            	}
        	}
        	answer += divider;
        }
        
        return answer;
    }
}