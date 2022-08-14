package easy;

import java.util.HashSet;

public class LinkedListCycle_141 {
	public static void main(String[] args) {
	}

	// easy approach but a bit slow, using hashset to record if there is a duplicate
	public static boolean hasCycle(ListNode head) {
		HashSet<ListNode> hash = new HashSet<ListNode>();
		while (head != null) {
			if (hash.contains(head)) {
				return true;
			}
			hash.add(head);
			head = head.next;
		}
		return false;
	}

	// smart approach using two pointer temp node to record, fast and slow, fast
	// moves 2 at a time and slow moves 1 at a time, fast will eventually reach slow
	// if there is a cycle
	public static boolean hasCycle2(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
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
