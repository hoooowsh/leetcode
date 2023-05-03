package medium;

public class PartitionList_86 {
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

	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode dum = new ListNode(-1);
		ListNode prev_small = null;
		ListNode prev_big = null;
		ListNode big_head = null;
		ListNode cur = head;
		while (cur != null) {
			// if current value is smaller
			if (cur.val < x) {
				if (prev_small == null) {
					dum.next = cur;
					prev_small = cur;
					cur = cur.next;
					prev_small.next = null;
				} else {
					prev_small.next = cur;
					prev_small = prev_small.next;
					cur = cur.next;
					prev_small.next = null;
				}
			}
			// if current value is bigger
			else {
				if (big_head == null) {
					big_head = cur;
					prev_big = cur;
					cur = cur.next;
					prev_big.next = null;
				} else {
					prev_big.next = cur;
					prev_big = prev_big.next;
					cur = cur.next;
					prev_big.next = null;
				}
			}
		}
		if (prev_small == null) {
			dum.next = big_head;
			return dum.next;
		}
		prev_small.next = big_head;
		return dum.next;
	}
}
