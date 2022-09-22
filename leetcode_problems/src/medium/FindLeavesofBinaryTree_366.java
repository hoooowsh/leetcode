package medium;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree_366 {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		findLeaves(root);
	}

	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		while (root.left != null || root.right != null) {
			List<Integer> temp = new ArrayList<>();
			helper(root, null, false, temp);
			result.add(temp);
		}
		List<Integer> temp = new ArrayList<>();
		temp.add(root.val);
		result.add(temp);
		return result;
	}

	public static void helper(TreeNode node, TreeNode prev, boolean isleft, List<Integer> list) {
		if (node == null) {
			return;
		}
		// condition
		if (node.left == null && node.right == null) {
			list.add(node.val);
			if (prev == null) {
				node = null;
				return;
			}
			if (isleft) {
				prev.left = null;
			} else {
				prev.right = null;
			}
			return;
		}
		helper(node.left, node, true, list);
		helper(node.right, node, false, list);
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
