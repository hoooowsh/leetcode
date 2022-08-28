package easy;

public class RemoveLinkedListElements_203 {
	public static void main(String[] args) {
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(6);
		test.next.next.next = new ListNode(3);
		test.next.next.next.next = new ListNode(4);
		test.next.next.next.next.next = new ListNode(5);
		test.next.next.next.next.next.next = new ListNode(6);
		removeElements(test, 6);
	}

	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		ListNode prev = null;
		boolean ishead = true;
		while (cur != null) {
			if (ishead) {
				if (cur.val == val) {
					head = cur;
					cur = cur.next;
				} else {
					head = cur;
					prev = cur;
					ishead = false;
					cur = cur.next;
				}
			} else {
				if (cur.val == val) {
					prev.next = cur.next;
					cur = cur.next;
				} else {
					prev = cur;
					cur = cur.next;
				}
			}
		}
		if (head.val == val) {
			return null;
		}
		return head;
	}

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
}
