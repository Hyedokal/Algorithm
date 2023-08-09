class Solution {
    public boolean solution(int x) {
        int xValue = x;
        int digitSum = 0;
        while(x>0){
            digitSum += x%10;
            x /= 10;
        }
        return xValue%digitSum == 0;
    }
}