package medium;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack_155 {

	// A very smart way to do it is store the current min value to each node of the
	// stack, when pop it, there is always a min value
	public static class MinStack {
		Stack<int[]> stack;

		public MinStack() {
			stack = new Stack<>();
		}

		public void push(int val) {
			int[] arr = new int[2];
			arr[0] = val;
			if (!stack.isEmpty()) {
				arr[1] = Math.min(stack.peek()[1], val);
				stack.push(arr);
			} else {
				arr[1] = val;
				stack.push(arr);
			}
		}

		public void pop() {
			stack.pop();
		}

		public int top() {
			return stack.peek()[0];
		}

		public int getMin() {
			return stack.peek()[1];
		}
	}
}
