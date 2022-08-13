package easy;

import java.util.HashSet;

public class LinkedListCycle_141 {
	public static void main(String[] args) {
	}

	public static boolean hasCycle(ListNode head) {
		HashSet<ListNode> hash = new HashSet<ListNode>();
		while (head != null) {
			if(hash.contains(head)) {
				return true;
			}
			hash.add(head);
			head = head.next;
		}
		return false;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
