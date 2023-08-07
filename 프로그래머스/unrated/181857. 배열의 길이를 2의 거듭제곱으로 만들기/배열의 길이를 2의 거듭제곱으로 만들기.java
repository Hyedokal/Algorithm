import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i : arr) {
        	al.add(i);
        }
        int targetSize = (int) Math.pow(2, Math.ceil(Math.log(arr.length)/Math.log(2)));
        for(int j=arr.length; j< targetSize; j++) {
        	al.add(0);
        }
        return al.stream().mapToInt(Integer::intValue).toArray();
    }
}