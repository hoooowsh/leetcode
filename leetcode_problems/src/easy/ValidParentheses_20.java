package easy;

import java.util.Stack;

public class ValidParentheses_20 {
	public static void main(String[] args) {
	}

	// simply using stack to solve it
	public boolean isValid(String s) {
		Stack<Character> q = new Stack<Character>();
		if (s.equals("") || s == null) {
			return true;
		}

		q.add(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				q.add('(');
			}
			if (s.charAt(i) == '[') {
				q.add('[');
			}
			if (s.charAt(i) == '{') {
				q.add('{');
			}
			if (s.charAt(i) == '}') {
				if (q.isEmpty()) {
					return false;
				}
				if (q.peek() == '{') {
					q.pop();
				} else {
					return false;
				}
			}
			if (s.charAt(i) == ')') {
				if (q.isEmpty()) {
					return false;
				}
				if (q.peek() == '(') {
					q.pop();
				} else {
					return false;
				}
			}
			if (s.charAt(i) == ']') {
				if (q.isEmpty()) {
					return false;
				}
				if (q.peek() == '[') {
					q.pop();
				} else {
					return false;
				}
			}
		}
		return q.isEmpty();
	}
}
