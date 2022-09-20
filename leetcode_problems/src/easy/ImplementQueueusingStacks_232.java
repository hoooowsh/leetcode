package easy;

import java.util.Stack;

public class ImplementQueueusingStacks_232 {
	public static void main(String args[]) {
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.pop();
		q.push(5);
		q.pop();
		q.pop();
		q.pop();
		q.pop();
	}

	public static class MyQueue {
		Stack<Integer> stack;
		Stack<Integer> stack2;

		public MyQueue() {
			stack = new Stack<Integer>();
			stack2 = new Stack<Integer>();
		}

		public void push(int x) {
			stack.push(x);
		}

		public int pop() {
			while (!stack.isEmpty()) {
				stack2.push(stack.pop());
			}
			int result = stack2.pop();
			while (!stack2.isEmpty()) {
				stack.push(stack2.pop());
			}
			return result;
		}

		public int peek() {
			while (!stack.isEmpty()) {
				stack2.push(stack.pop());
			}
			int result = stack2.peek();
			while (!stack2.isEmpty()) {
				stack.push(stack2.pop());
			}
			return result;
		}

		public boolean empty() {
			return stack.isEmpty();
		}
	}
}
