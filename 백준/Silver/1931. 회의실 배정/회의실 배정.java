import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Meeting implements Comparable<Meeting>{
        int start, end;
        Meeting(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end);
        }
    }
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int n = 0; n <N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[n] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);
        answer = 1;
        int prevIdx = 0;
        for(int n=1; n<N; n++){
            if(meetings[prevIdx].end <= meetings[n].start) {
                prevIdx = n;
                answer++;
            }
        }
        System.out.println(answer);
    }
}