import java.util.*;
class Solution {
    //바뀌는 글자 수가 1개인지 체크
    //바뀌는 횟수 체크
    //바꾸고 나서 target과 일치한지 체크
    static int answer;
    static String output;
    static String[] dict;
    static boolean[] visited;
    //정수 배열: [단어 인덱스, 바꾼 횟수];
    static Queue<int[]> queue;
    public int solution(String begin, String target, String[] words) {
        output = target;
        dict = new String[words.length+1];
        for(int i=0; i<words.length; i++){
            dict[i] = words[i];
        }
        //마지막 인덱스에 begin 저장
        dict[words.length] = begin;
        answer = 0;
        queue = new LinkedList<>();
        visited = new boolean[words.length];
        queue.offer(new int[]{words.length, 0});
        BFS();
        
        return answer;
    }
    static void BFS(){
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            //target 단어를 찾으면 그만한다.
            if(dict[arr[0]].equals(output)){
                answer = arr[1];
                return;
            }
            //너무 많이 돌면 그
            for(int i=0; i<dict.length-1; i++){
                //같은 번호거나, 이미 방문한 단어이면 무시.
                if(arr[0] == i || visited[i]) continue;
                String str1 = dict[arr[0]];
                String str2 = dict[i];
                int tmp = 0;
                for(int j=0; j<str1.length(); j++){
                    //다른 글자가 몇 개인가 센다
                    if(str1.charAt(j) != str2.charAt(j)){
                        tmp++;
                    }
                }
                if(tmp == 1) {
                    queue.offer(new int[]{i, arr[1]+1});
                    visited[i] = true;
                }
            }
        }
        return;
    }
}