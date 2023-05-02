package medium;

import java.util.ArrayList;

public class RemoveDuplicatesfromSortedList2_82 {
	public static class ListNode {
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

	public static void main(String[] args) {
//		ListNode test = new ListNode(1);
//		test.next = new ListNode(2);
//		test.next.next = new ListNode(3);
//		test.next.next.next = new ListNode(3);
//		test.next.next.next.next = new ListNode(4);
//		test.next.next.next.next.next = new ListNode(4);
//		test.next.next.next.next.next.next = new ListNode(5);
//		deleteDuplicates(test);
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(2);
//		test.next.next.next = new ListNode(2);
//		test.next.next.next.next = new ListNode(3);
		deleteDuplicates(test);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode dum = new ListNode(-101);
		ListNode temp = dum;
		ListNode prev = dum;
		ListNode cur = head;
		while (cur != null) {
			// if it duplicates
			if (cur.val == prev.val || cur.next != null && cur.val == cur.next.val) {
				prev = cur;
				cur = cur.next;
			} else if (cur.next == null && cur.val == prev.val) {
				prev = cur;
				cur = cur.next;
			} else if (cur.next == null && cur.val != prev.val) {
				prev = cur;
				temp.next = cur;
				temp = temp.next;
				cur = cur.next;
				temp.next = null;
			} else {
				prev = cur;
				temp.next = cur;
				temp = temp.next;
				cur = cur.next;
				temp.next = null;
			}
		}
		return dum.next;
	}
}
