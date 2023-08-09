class Solution {
	public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<= right; i++) {
        	if(countDivisor(i)%2 == 0){
                answer += i;
            } else{
                answer -= i;
            }
        }
        return answer;
    }
    
	public static int countDivisor(int n) {
		int divisor = 0;
		for(int i=1; i<=Math.sqrt(n); i++) {
			if(n % i == 0) {
				divisor++;
			}
		}
		return ((Math.sqrt(n)%1 == 0) && (n%Math.sqrt(n) == 0))? divisor*2 - 1 : divisor*2;
	}
}