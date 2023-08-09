import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Integer> attends = new ArrayList<Integer>();
        for(int i=0; i<attendance.length;i++) {
        	if(attendance[i]) {
        		//참석 가능 학생의 인덱스 추출
        		attends.add(i);
        	}
        }
        int[] qualifiers = new int[attends.size()];
        for(int i=0; i<qualifiers.length; i++) {
        	//참석 가능 학생들의 등수 저장
        	qualifiers[i] = rank[attends.get(i)];
        }
        //등수 sorting
        Arrays.sort(qualifiers);
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=0; i<rank.length; i++) {
        	if(rank[i] == qualifiers[0]) {
        		//1등 학생 인덱스 저장
        		a = i;
        	} else if(rank[i] == qualifiers[1]) {
        		b = i;
        	} else if(rank [i] == qualifiers[2]) {
        		c = i;
        	}
        }
        return 10000*a + 100*b + c;
    }
}



