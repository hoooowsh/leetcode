package easy;

import java.util.ArrayList;

public class PalindromeLinkedList_234 {
	public static void main(String args[]) {

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return false;
		}
		ArrayList<Integer> arr = new ArrayList<>();
		while (head != null) {
			arr.add(head.val);
			head = head.next;
		}
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) != arr.get(arr.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	// another smart solution using a public pointer, this pointer points to the
	// head, move to next when current is the tail, recursive method
	private ListNode frontPointer;

	private boolean recursivelyCheck(ListNode currentNode) {
		if (currentNode != null) {
			if (!recursivelyCheck(currentNode.next)) {
				return false;
			}
			if (currentNode.val != frontPointer.val) {
				return false;
			}
			frontPointer = frontPointer.next;
		}
		return true;
	}

	public boolean isPalindrome2(ListNode head) {
		frontPointer = head;
		return recursivelyCheck(head);
	}

	// if O(1) extra space is required, just count the size of the linked lists

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
}
