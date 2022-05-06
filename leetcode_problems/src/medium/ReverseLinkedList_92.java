package medium;

public class ReverseLinkedList_92 {
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
//		ListNode p = new ListNode(1);
//		p.next = new ListNode(2);
//		p.next.next = new ListNode(3);
//		p.next.next.next = new ListNode(4);
//		p.next.next.next.next = new ListNode(5);
//		ListNode test = reverseBetween(p, 2, 4);
//		System.out.println(test.val);

		ListNode q = new ListNode(3);
		q.next = new ListNode(5);
		ListNode test2 = reverseBetween(q, 1, 2);
		System.out.println(test2.val);

	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
		if (left == right) {
			return head;
		}
		int count = 0;
		// these four for head and tail swap
		ListNode n1prev = null;
		ListNode n1 = null;
		ListNode n2next = null;
		ListNode n2 = null;
		// these two for looping
		ListNode cur = head;
		ListNode prev = null;
		while (count < right) {
			// while not achieve left, meaning no change for position
			if (count < left - 1) {
				count++;
				prev = cur;
				cur = cur.next;
				continue;
			}
			// start reverse
			else if (count == left - 1) {
				n1 = cur;
				n1prev = prev;
				count++;
				prev = cur;
				cur = cur.next;
			}
			// while in between left and right, meaning need to reverse
			else if (count >= left && count < right - 1) {
				ListNode temp = cur;
				cur = cur.next;
				temp.next = prev;
				prev = temp;
				count++;
			}
			// end reverse
			else if (count == right - 1) {
				n2next = cur.next;
				n2 = cur;
				ListNode temp = cur;
				temp.next = prev;
				break;
			}
			// while after right, break loop and return
			else {
				break;
			}
		}
		if (n1prev != null) {
			n1prev.next = n2;
		} else {
			head = n2;
		}
		if (n2next != null) {
			n1.next = n2next;
		}else {
			n1.next = null;
		}

		return head;
	}
}
