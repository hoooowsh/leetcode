package medium;

import java.util.Stack;

public class SimplifyPath_71 {
	public static void main(String[] args) {
		String str = "/home//foo/";
		String result = simplifyPath(str);
		System.out.println(result);
	}

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] arr = path.split("/");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == "" || arr[i].equals(".")) {
				continue;
			} else if (arr[i].equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.add(arr[i]);
			}
		}
		String result = "/";
		int temp = stack.size();
		for (int i = 0; i < temp; i++) {
			result = "/" + stack.pop() + result;
		}
		if (result.length() > 1 && result.charAt(result.length() - 1) == '/') {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
}
