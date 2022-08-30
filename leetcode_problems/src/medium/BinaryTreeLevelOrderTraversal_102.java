package medium;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		levelOrder(root);
		System.out.println();
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if (root == null) {
			return result;
		}
		helper(result, root, 0);
		return result;
	}

	public static void helper(List<List<Integer>> result, TreeNode node, int deep) {
		if (node == null) {
			return;
		}
		if (result.size() <= deep) {
			result.add(deep, new LinkedList<Integer>());
		}
		helper(result, node.left, deep + 1);
		helper(result, node.right, deep + 1);
		result.get(deep).add(node.val);
		return;
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
