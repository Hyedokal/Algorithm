import java.util.ArrayList;

class Solution {
    public String[] solution(String myStr) {
    	String noA = myStr.replace('a', 'b');
    	String noAB = noA.replace('b', 'c');
    	String[] words = noAB.split("c");
    	ArrayList<String> al = new ArrayList<String>();
    	for(String word : words) {
    		String noSpace = word.trim();
    		if(!noSpace.isBlank()) {
    		al.add(noSpace);
    		}
    	}
    	return (al.size() != 0)? al.toArray(new String[0]) : new String[]{"EMPTY"};
    }
}