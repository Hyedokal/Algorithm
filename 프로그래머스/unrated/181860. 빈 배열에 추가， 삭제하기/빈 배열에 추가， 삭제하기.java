import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> intAl = new ArrayList<Integer>();
        for(int i=0; i<flag.length; i++) {
        	if(flag[i]) {
        		for(int j=0; j<arr[i]*2; j++) {
        			intAl.add(arr[i]);
        		}
        	} else {
        		for(int k=0; k<arr[i]; k++) {
        			intAl.remove(intAl.size()-1);
        		}
        	}
        }
        return intAl.stream().mapToInt(Integer::intValue).toArray();
    }
}