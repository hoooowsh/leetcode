package medium;

import java.util.ArrayList;

public class ConvertSortedListtoBST_109 {
	public static void main(String[] args) {
		ListNode node = new ListNode(-10);
		node.next = new ListNode(-3);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(5);
		node.next.next.next.next = new ListNode(9);
		sortedListToBST(node);
	}

	// convert the whole linked list to an array and then make it to a tree
	public static TreeNode sortedListToBST(ListNode head) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (head != null) {
			arr.add(head.val);
			head = head.next;
		}
		int lo = 0;
		int hi = arr.size() - 1;
		return helper(arr, lo, hi);
	}

	public static TreeNode helper(ArrayList<Integer> arr, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		TreeNode node = new TreeNode(arr.get(mid));
		if (lo == hi) {
			return node;
		}
		node.left = helper(arr, lo, mid - 1);
		node.right = helper(arr, mid + 1, hi);
		return node;
	}

	// using inorder traversal
	public static TreeNode sortedListToBST2(ListNode head) {
		TreeNode result = new TreeNode(1);
		return result;
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

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
