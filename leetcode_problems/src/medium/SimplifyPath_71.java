package medium;

import java.util.Stack;

public class SimplifyPath_71 {
	public static void main(String[] args) {
		String str = "/...";
		String result = simplifyPath(str);
		System.out.println(result);
	}

	public static String simplifyPath(String path) {
		Stack<Character> stack = new Stack<Character>();
		// go through input string first
		for (int i = 0; i < path.length(); i++) {
			char temp = path.charAt(i);
			if (temp == '.') {
				if (stack.isEmpty()) {
					stack.push(temp);
				}
				// .. situation, go upper level
				else if (stack.peek() == '.') {
					stack.pop();
					char s = 's';
					if(stack.size() != 1) {
						s = stack.pop();
					}
					if(s == '.') {
						stack.push('.');
						stack.push('.');
						continue;
					}
					while (!stack.isEmpty()) {
						if (stack.peek() == '/') {
							break;
						} else {
							stack.pop();
						}
					}
				}
				// else, stay
				else {
					stack.push('.');
				}
			} else if (temp == '/') {
				if (stack.isEmpty()) {
					stack.push(temp);
				}
				// for multiple / situation
				else if (stack.peek() == '/') {
					continue;
				} else if (stack.peek() == '.') {
					stack.pop();
				}
				// for single / situation
				else {
					stack.push('/');
				}
			} else {
				stack.push(temp);
			}
		}
		// go through finished stack and get the result
		String result = "";
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}
		if (result.length() == 0) {
			return result;
		}
		if (result.charAt(result.length() - 1) == '/' && result.length() != 1) {
			result = result.substring(0, result.length() - 1);
		}
		if (result.charAt(result.length() - 1) == '.') {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
}
