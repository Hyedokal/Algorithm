class Solution {
    public long solution(int price, int money, int count) {
        long charge = (long) price*count*(count+1)/2;
        return (charge > money)? charge-money : 0;
    }
}