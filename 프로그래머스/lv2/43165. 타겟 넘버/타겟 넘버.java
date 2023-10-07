class Solution {
    static int count;
    static int[] inst;
    static int t;
    public int solution(int[] numbers, int target) {
        count = 0;
        t = target;
        inst = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            inst[i] = numbers[i];
        }
        DFS(inst[0], 1);
        DFS(inst[0] * (-1), 1);
        
        return count;
    }
    static void DFS(int sum, int calc){
        if(sum == t && calc == inst.length){
            count++;
        }
        if(calc < inst.length){
            DFS((sum + inst[calc]), calc+1);
            DFS((sum - inst[calc]), calc+1);
        }
    }
    
}