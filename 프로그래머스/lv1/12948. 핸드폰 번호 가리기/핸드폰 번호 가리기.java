class Solution {
    public String solution(String phone_number) {
    	String stars = "";
        String backNumber = phone_number.substring(phone_number.length()-4);
        for(int i=0; i<phone_number.length()-backNumber.length(); i++) {
        	stars += "*";
        }
        return stars+backNumber;
    }
}