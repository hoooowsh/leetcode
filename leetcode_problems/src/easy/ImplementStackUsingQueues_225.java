package easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {

	public static void main(String[] args) {

	}

	class MyStack {
		private Queue<Integer> q;

		public MyStack() {
			q = new LinkedList<>();
		}

		public void push(int x) {
			q.add(x);
			for (int i = 0; i < q.size() - 1; i++) {
				q.add(q.remove());
			}
		}

		public int pop() {
			return q.poll();
		}

		public int top() {
			return q.peek();
		}

		public boolean empty() {
			return q.isEmpty();
		}
	}
}
