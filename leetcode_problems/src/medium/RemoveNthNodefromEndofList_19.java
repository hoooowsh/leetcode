package medium;

import java.util.ArrayList;

public class RemoveNthNodefromEndofList_19 {
	public static void main(String[] args) {
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// using a list to store all nodes and track it from tail
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ArrayList<ListNode> Nodearr = new ArrayList<ListNode>();
		ListNode current = head;
		while (current.next != null) {
			Nodearr.add(current);
			current = current.next;
		}
		Nodearr.add(current);

		if (Nodearr.size() == 1) {
			return null;
		}
		int NthPos = Nodearr.size() - n - 1;
		if (NthPos < 0) {
			return Nodearr.get(1);
		}
		if (n == 1) {
			Nodearr.get(NthPos).next = null;
			return head;
		} else {
			Nodearr.get(NthPos).next = Nodearr.get(NthPos + 2);
			return head;
		}
	}
}
