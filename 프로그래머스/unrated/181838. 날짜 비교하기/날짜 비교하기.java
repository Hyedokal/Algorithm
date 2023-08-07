class Solution {
    public int solution(int[] date1, int[] date2) {
        String str1 = "";
        String str2 = "";
        for(int i : date1){
            str1 += String.valueOf(i);
        }
        for(int i : date2){
            str2 += String.valueOf(i);
        }
        return (Integer.parseInt(str1)<Integer.parseInt(str2))? 1:0;
    }
}