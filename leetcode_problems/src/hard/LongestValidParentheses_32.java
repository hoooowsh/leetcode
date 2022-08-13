package hard;

import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses_32 {
	public static void main(String[] args) {
		String test = "(()";
		int len = longestValidParentheses(test);
		System.out.println(len);
	}

	// using DP. The array is to store all valid index, a stack is used to decide if
	// the parentheses make sense, after looping through all elements, go over the
	// array again the get the max
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] arr = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.add(i);
			} else {
				if (!stack.isEmpty()) {
					int start = stack.pop();
					arr[start] = true;
					arr[i] = true;
				}
			}
		}
		int max = 0;
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true) {
				counter++;
				if (counter > max) {
					max = counter;
				}
			} else {
				counter = 0;
			}
		}

		return max;
	}
}
