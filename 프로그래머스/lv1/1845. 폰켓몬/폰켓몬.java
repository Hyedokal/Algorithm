import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
    	
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int kinds = set.size();
        return Math.min(answer, kinds);
    }
}