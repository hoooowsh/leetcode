package medium;

public class OddEvenLinkedList_328 {
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

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode oddHead = null;
		ListNode oddCur = null;
		ListNode evenHead = null;
		ListNode evenCur = null;
		ListNode cur = head;
		int counter = 1;
		while (cur != null) {
			// if odd
			if (counter % 2 != 0) {
				// if odd head
				if (oddHead == null) {
					oddHead = cur;
					oddCur = cur;
				}
				// if not odd head
				else {
					oddCur.next = cur;
					oddCur = oddCur.next;
				}
			}
			// if even
			else {
				// if odd head
				if (evenHead == null) {
					evenHead = cur;
					evenCur = cur;
				}
				// if not odd head
				else {
					evenCur.next = cur;
					evenCur = evenCur.next;
				}
			}
			cur = cur.next;
			counter++;
		}
		if (evenCur != null) {
			evenCur.next = null;
		}
		oddCur.next = evenHead;
		return head;
	}
}
