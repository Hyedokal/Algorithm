class Solution {
	
	 public int[][] solution(int n) {
	        int[][] answer = new int[n][n];
	        int toNSquare = 1;
	        int row = 0;
	        int column = 0;
	        int line = 1;
	        //각 line의 한계 인덱스들
	        int breakpoint1 = n-1;
	        int breakpoint2 = 0;
	        int breakpoint3 = 1;
	        while(line <= 2*n -1) {
	        	if(line % 4 == 1) {
	        		// ->
	        		while(answer[row][column] == 0) {
	        			answer[row][column] = toNSquare++;
	        			if(column < breakpoint1) {column++;}
	        		}
	        		line++;
	        		row++;
	        	} else if(line % 4 == 2) {
	        		// 아래
	        		while(answer[row][column] == 0) {
	        			answer[row][column] = toNSquare++;
	        			if(row < breakpoint1) {row++;}
	        		}
	        		line++;
	        		column--;
	        		breakpoint1--;
	        	} else if(line % 4 == 3) {
	        		// <-
	        		while(answer[row][column] == 0) {
	        			answer[row][column] = toNSquare++;
	        			if(column > breakpoint2) {column--;}
	        		}
	        		line++;
	        		row--;
	        		breakpoint2++;
	        	} else {
	        		// 위
	        		while(answer[row][column] == 0) {
	        			answer[row][column] = toNSquare++;
	        			if(row>breakpoint3) {row--;}
	        		}
	        		line++;
	        		column++;
	        		breakpoint3++;
	        	}
	        }
	        
	        return answer;
	    }
    
}