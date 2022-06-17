package hard;

import java.util.ArrayList;

public class ReverseNodesinKGroup_25 {
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
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		// l.next.next = new ListNode(3);
		// l.next.next.next = new ListNode(4);
		// l.next.next.next.next = new ListNode(5);
		// l.next.next.next.next.next = new ListNode(2);
		ListNode test = reverseKGroup(l, 2);
	}

	// This version store k nodes in an arraylist, then reverse it, slow but easy to
	// code
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		int count = 0;
		ListNode cur = head;
		ListNode prev = null;
		boolean boo = true;
		while (cur != null) {
			if (count == 0) {
				list.add(cur);
				cur = cur.next;
				count++;
			} else if (count == k - 1) {
				list.add(cur);
				cur = cur.next;
				count++;
				for (int i = 0; i < count; i++) {
					if (boo) {
						boo = false;
						prev = list.get(list.size() - i - 1);
						head = prev;
					} else {
						prev.next = list.get(list.size() - i - 1);
						prev = prev.next;
					}
				}
				list.removeAll(list);
				count = 0;
			} else {
				list.add(cur);
				cur = cur.next;
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			prev.next = list.get(i);
			prev = prev.next;
		}
		prev.next = null;
		return head;
	}

	public static ListNode reverseKGroup2(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		ListNode cur = head;
		ListNode prev = new ListNode(-1);

		int counter = 0;
		while (cur != null) {
			if (counter == k - 1) {

			} else {

			}
		}
		return head;
	}
}
