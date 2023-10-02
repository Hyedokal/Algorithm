class Solution {
    public int solution(int[][] sizes) {
    	//일단 명함의 가로 세로 중 더 큰 쪽을 가로에 다 몰아놓는다.
    	for(int i=0; i<sizes.length; i++) {
    		if(sizes[i][1] > sizes[i][0]) {
    			int temp = sizes[i][0];
    			sizes[i][0] = sizes[i][1];
    			sizes[i][1] = temp;
    		}
    	}
    	
    	//가로세로 따로 저장 후 각각의 최댓값 찾기
    	int[] widths = new int[sizes.length];
    	int[] heights = new int[sizes.length];
    	for(int i=0; i<sizes.length; i++) {
    		widths[i] = sizes[i][0];
    	}
    	for(int j=0; j<sizes.length; j++) {
    		heights[j] = sizes[j][1];
    	}
    	int width = widths[0];
    	for(int x=1; x<widths.length; x++) {
    		width = Math.max(width, widths[x]);
    	}
    	int height = heights[0];
    	for(int y=1; y<widths.length; y++) {
    		height = Math.max(height, heights[y]);
    	}
    	return width * height;
    }
}