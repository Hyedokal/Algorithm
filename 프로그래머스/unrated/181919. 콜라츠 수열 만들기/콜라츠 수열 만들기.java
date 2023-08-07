import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int n) {
        int first = n;
		List<Integer> intList = new ArrayList<Integer>();
		int[] answer = {};
		int count = 1;
	    while(n != 1){
	        if(n%2==0){
	            n /= 2;
	        } else{
	            n = 3*n + 1;
	        }
	        intList.add(n);
	        count++;
	    }
	    answer = new int[count];
	    Integer[] integerArray = intList.toArray(new Integer[0]);
	    int[] intArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
	    answer[0] = first;
	    System.arraycopy(intArray, 0, answer, 1, count-1);
	    return answer;
    }
}