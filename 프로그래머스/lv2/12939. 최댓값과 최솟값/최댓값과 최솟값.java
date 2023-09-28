class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int[] ints = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ints[i] = Integer.parseInt(nums[i]);
        }
        
        int min = ints[0];
        int max = ints[0];
        for(int i=0; i<ints.length; i++){
            min = (min < ints[i])? min : ints[i];
            max = (max > ints[i])? max : ints[i];
        }
        String answer = min + " " + max;
        return answer;
    }
}