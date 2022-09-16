package medium;

import java.util.ArrayList;

public class ReorderList_143 {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		reorderList(head);
	}

	public static void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ArrayList<ListNode> arr = new ArrayList<>();
		while (head != null) {
			arr.add(head);
			head = head.next;
			arr.get(arr.size() - 1).next = null;
		}
		if (arr.size() == 1) {
			return;
		}
		for (int i = 0; i < (arr.size() + 1) / 2; i++) {
			if (i == 0) {
				arr.get(i).next = arr.get(arr.size() - 1 - i);
			} else if (i == (arr.size()) / 2 && arr.size() % 2 != 0) {
				arr.get(arr.size() - i).next = arr.get(i);
			} else {
				arr.get(arr.size() - i).next = arr.get(i);
				arr.get(i).next = arr.get(arr.size() - 1 - i);
			}
		}

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
