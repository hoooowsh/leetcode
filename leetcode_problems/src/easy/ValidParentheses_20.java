package easy;

import java.util.Stack;

public class ValidParentheses_20 {
	public static void main(String[] args) {

	}

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '{' || cur == '[' || cur == '(') {
				stack.add(cur);
			} else if (cur == ')') {
				if (stack.size() <= 0) {
					return false;
				}
				if (stack.peek() != '(') {
					return false;
				}
				stack.pop();
				continue;
			} else if (cur == ']') {
				if (stack.size() <= 0) {
					return false;
				}
				if (stack.peek() != '[') {
					return false;
				}
				stack.pop();
				continue;
			} else if (cur == '}') {
				if (stack.size() <= 0) {
					return false;
				}
				if (stack.peek() != '{') {
					return false;
				}
				stack.pop();
				continue;
			}
		}
		if (stack.size() != 0) {
			return false;
		}
		return true;
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
