package hard;

import java.util.Stack;

public class BasicCalculator_224 {
	public static void main(String args[]) {
		String test = "(1+(4+5+2)-3)+(6+8)";
		String test2 = "1-(     -2)";
		String test3 = " 2-1 + 2 ";
		String test4 = "0";
		String test5 = "(1)";
		String test6 = "- (3 + (4 + 5))";

		int tt = calculate(test6);
		System.out.println(tt);
//		String str = "-9";
//		System.out.println(Integer.valueOf(str));
	}

	public static int calculate(String s) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int digitlen = getnumlen(s, i);
				stack.push(s.substring(i, i + digitlen));
				i += digitlen - 1;
			} else if (s.charAt(i) == ' ') {
				continue;
			} else if (s.charAt(i) == '(') {
				stack.push("(");
				continue;
			} else if (s.charAt(i) == '+') {
				stack.push("+");
			} else if (s.charAt(i) == '-') {
				stack.push("-");
			} else {
				Stack<Integer> stack_temp = new Stack<>();
				while (stack.peek() != "(") {
					String cur = stack.pop();
					if (cur == "-") {
						int num = stack_temp.pop();
						stack_temp.push(-num);
					} else if (cur == "+") {
						continue;
					} else {
						stack_temp.push(Integer.valueOf(cur));
					}
				}
				stack.pop();
				int num = stack_temp.pop();
				while (!stack_temp.isEmpty()) {
					num += stack_temp.pop();
				}
				stack.push(String.valueOf(num));
			}
		}

		Stack<Integer> stack_temp = new Stack<>();
		while (!stack.isEmpty()) {
			String cur = stack.pop();
			if (cur == "-") {
				int num = stack_temp.pop();
				stack_temp.push(-num);
			} else if (cur == "+") {
				continue;
			} else {
				stack_temp.push(Integer.valueOf(cur));
			}
		}
		int num = stack_temp.pop();
		while (!stack_temp.isEmpty()) {
			num += stack_temp.pop();
		}

		return num;
	}

	public static int getnumlen(String s, int index) {
		int counter = 0;
		for (int i = index; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				counter++;
			} else {
				break;
			}
		}
		return counter;
	}
}
