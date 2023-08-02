import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
		int answer = 0;
		int[] arr = {a, b, c, d};
		Arrays.sort(arr);
		int p = arr[0]; int q = arr[1]; int r = arr[2]; int s = arr[3];
		
		if(p == q && q == r && r == s) {
			answer = 1111 * p;
		}
		
		if((p == q && q == r && r != s)) {
			answer = (10 * r + s) * (10 * r + s);
		} else if((p != q && q == r && r == s)) {
				answer = (10 * q + p) * (10 * q + p);
			}
	
		if(p == q && q != r && r == s) {
			answer = Math.abs((p + r) * (p - r));
		}
	
		if( p == q && q != r && r != s ) {
			answer = r * s;
		} else if(p != q && q == r && r != s){
			answer = p * s;
		} else if (p != q && q != r && r == s) {
			answer = p * q;
		}
		
		if(p != q && q != r && r != s) {
			answer = p;
		}
		return answer;
	}
}