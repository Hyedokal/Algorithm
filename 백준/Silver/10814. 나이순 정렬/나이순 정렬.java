import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            members[i] = new Member(Integer.parseInt(s[0]), s[1], i);
        }
        Arrays.sort(members);
        for(Member m : members){
            System.out.println(m.age+" "+m.name);
        }
    }

    static class Member implements Comparable{
        int age;
        String name;
        int index;
        Member(int age, String name, int index){
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            if(o instanceof Member){
                Member m = (Member) o;
                if(this.age == m.age){
                    return this.index - m.index;
                } else{
                    return this.age - m.age;
                }
            }
            return 0;
        }
    }
}
