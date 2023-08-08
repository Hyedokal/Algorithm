import java.util.ArrayList;

class Solution {
	public int[] solution(int[] arr) {
		int minIdx = 0;
		int maxIdx = 0;
		ArrayList<Integer> idxList = new ArrayList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		//2가 있는 인덱스 목록을 받는다
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] == 2) {
        		idxList.add(i);
        	}
        }
        //2가 없으면..
        if(idxList.size() == 0) {
        	return new int[] {-1};
        } else {
        	minIdx = idxList.get(0);
        	maxIdx = idxList.get(idxList.size()-1);
        	for(int k = minIdx; k<= maxIdx; k++) {
        		al.add(arr[k]);
        	}	
        }
        return al.stream().mapToInt(Integer::intValue).toArray();
    }
}