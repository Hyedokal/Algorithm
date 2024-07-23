class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health - attacks[0][1];
        if(attacks.length > 1){
            for(int i=1; i<attacks.length; i++){
                int time = attacks[i][0];
                int timeGap = (attacks[i][0] - attacks[i-1][0] -1);
                int damage = attacks[i][1];
                answer += (timeGap / bandage[0] * bandage[2] + timeGap*bandage[1]);
                if(answer > health) answer = health;
                answer -= damage;
                if(answer <= 0) {
                    answer = -1;
                    break;
                }
            }    
        }
        return answer;
    }
}