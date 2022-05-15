package medium;

public class SwapNodesinPairs_24 {
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
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(3);
		swapPairs(test);
	}

	public static ListNode swapPairs(ListNode head) {
		// for case head is null or head.next is null
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode prev = null;
		while (cur != null) {
			// if the first add
			if (prev == null && cur.next != null) {
				head = cur.next;
				prev = cur;
				// reset cur for next iteration
				cur = cur.next.next;
				head.next = prev;
			} 
			// if there is a pair needs to swap
			else if (cur.next != null) {
				ListNode first = cur.next;
				prev.next = first;
				prev = cur;
				cur = cur.next.next;
				first.next = prev;
			} 
			// if this is the last node 
			else {
				prev.next = cur;
			}
		}
		if(cur == null) {
			prev.next = null;
		}
		return head;
	}
}
