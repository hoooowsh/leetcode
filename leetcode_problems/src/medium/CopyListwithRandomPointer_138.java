package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class CopyListwithRandomPointer_138 {
	public static void main(String args[]) {
		Node n1 = new Node(7);
		Node n2 = new Node(13);
		Node n3 = new Node(11);
		Node n4 = new Node(10);
		Node n5 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n2.random = n1;
		n3.random = n5;
		n4.random = n3;
		n5.random = n1;
		Node test = copyRandomList(n1);
	}

	public static Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		HashMap<Node, Integer> hash = new HashMap<>();
		ArrayList<Node> pos_old = new ArrayList<>();
		ArrayList<Node> pos_new = new ArrayList<>();
		int counter = 0;
		while (head != null) {
			hash.put(head, counter);
			pos_old.add(head);
			pos_new.add(new Node(head.val));
			head = head.next;
			counter++;
		}
		for (int i = 0; i < pos_new.size(); i++) {
			if (i != pos_new.size() - 1) {
				pos_new.get(i).next = pos_new.get(i + 1);
				if (pos_old.get(i).random != null) {
					int random_pos = hash.get(pos_old.get(i).random);
					pos_new.get(i).random = pos_new.get(random_pos);
				}
			} else {
				if (pos_old.get(i).random != null) {
					int random_pos = hash.get(pos_old.get(i).random);
					pos_new.get(i).random = pos_new.get(random_pos);
				}
			}
		}
		return pos_new.get(0);
	}

	public static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
