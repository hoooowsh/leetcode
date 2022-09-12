package medium;

import java.util.Stack;

public class DecodeString_394 {
	public static void main(String args[]) {
		String test = "1[a3[a2[c]]ab]";
		String test2 = "100[leetcode]";
		String tt = decodeString(test2);
		System.out.println(tt);

	}

	// can have a stack of array, array record num of repeat, "[" index, then
	// replace the value inside []. It is slow but working
	public static String decodeString(String s) {
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(s.charAt(i))) {
				int num = digitnum(s, i);
				int[] arr = new int[2];
				arr[0] = Integer.valueOf(s.substring(i, i + num));
				stack.push(arr);
				i += num - 1;
			} else if (s.charAt(i) == '[') {
				stack.peek()[1] = i;
			} else if (s.charAt(i) == ']') {
				int[] arr = stack.pop();
				String temp = "";
				for (int j = 0; j < arr[0]; j++) {
					temp += s.substring(arr[1] + 1, i);
				}
				String t1 = s.substring(0, arr[1] - String.valueOf(arr[0]).length());
				String t2 = s.substring(i + 1, s.length());
				s = t1 + temp + t2;
				i = arr[1] + temp.length() - 1 - String.valueOf(arr[0]).length();
			} else {

			}
		}
		return s;
	}

	// helper method to get the digit val right before "["
	public static int digitnum(String s, int num) {
		int result = 1;
		for (int i = 1; i < 3; i++) {
			if (Character.isDigit(s.charAt(num + i))) {
				result++;
			} else {
				break;
			}
		}
		return result;
	}

	public static String decodeString2(String s) {
		return "";
	}
}
