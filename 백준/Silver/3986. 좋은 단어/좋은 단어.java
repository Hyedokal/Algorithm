import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			char[] c = S.toCharArray();
			Stack<Character> stack = new Stack<>();
			if (c.length % 2 == 1) {
				continue;
			}
			for (int j = 0; j < c.length; j++) {
				if (stack.isEmpty()) {
					stack.push(c[j]);
					continue;
				}
				if (stack.peek() == 'A' && c[j] == 'A') {
					stack.pop();
				} else if (stack.peek() == 'B' && c[j] == 'B') {
					stack.pop();
				} else {
					stack.push(c[j]);
				}
			}
			if (stack.isEmpty())
				cnt++;
		}
		System.out.println(cnt);
	}
}
