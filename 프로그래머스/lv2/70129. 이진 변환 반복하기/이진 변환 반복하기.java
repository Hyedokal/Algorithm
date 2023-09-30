class Solution {
    public int[] solution(String s) {
        int zeros = 0;
        int count = 0;
        String bNum = s;
        while(bNum.length() != 1){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<bNum.length(); i++){
                if(bNum.charAt(i) == '0'){
                    zeros++;
                } else{
                    sb.append("1");
                }
            }
            int decimal = sb.toString().length(); //0 제거 후 길이
            bNum = Integer.toBinaryString(decimal);
            count++;
        }
        
        int[] answer = new int[]{count, zeros};
        return answer;
    }
}