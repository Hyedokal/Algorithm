class Solution {
    public int solution(int[] num_list) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<num_list.length; i+=2) {
        	sum1 += num_list[i];
        }
        for(int i=1; i<num_list.length; i+=2) {
        	sum2 += num_list[i];
        }
        return (sum1 > sum2)? sum1 : sum2;
    }
}