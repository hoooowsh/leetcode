package medium;

import java.util.ArrayList;

public class RoateList_61 {
	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
//		n.next.next = new ListNode(3);
//		n.next.next.next = new ListNode(4);
//		n.next.next.next.next = new ListNode(5);
		rotateRight(n, 0);
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode temp = head;
		ArrayList<ListNode> arr = new ArrayList<>();
		while (head != null) {
			arr.add(head);
			head = head.next;
		}
		int rotate = arr.size() - k % arr.size();
		if (arr.size() <= 1) {
			return temp;
		}
		if (rotate == arr.size()) {
			return temp;
		}
		arr.get(arr.size() - 1).next = arr.get(0);
		arr.get(rotate - 1).next = null;
		return arr.get(rotate);
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
