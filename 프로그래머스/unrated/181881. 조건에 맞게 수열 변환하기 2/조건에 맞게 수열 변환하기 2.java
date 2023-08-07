class Solution {
    public int solution(int[] arr) {
    	int[] preArr = new int[arr.length];
    	int count = 0;
    	int test = 0;
    	boolean flag = true;
    	while(flag) { 
    		System.arraycopy(arr, 0, preArr, 0, arr.length);
            test = 0;
    		//arr에 문제가 원하는 작업을 한다.
	    	for(int i = 0; i<arr.length; i++) {
	    		if(arr[i] >= 50 && arr[i]%2 ==0) {
	    			arr[i]/=2;
	    		} else if(arr[i] < 50 && arr[i]%2 ==1) {
	    			arr[i] = arr[i] * 2 + 1;
	    		}
	    	}
	    	//작업을 1회 더 했다는 표시
			count++;
			for(int k = 0; k<arr.length; k++) {
				if(arr[k] == preArr[k]) {
					test++;
				}
			}
			//배열이 서로 같으면 루프 탈출
			if(test == arr.length) {
				flag = false;
			}
    	}
    	return count-1;
    }
}
