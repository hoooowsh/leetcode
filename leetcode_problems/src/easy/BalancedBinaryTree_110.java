package easy;

import java.util.Stack;

public class BalancedBinaryTree_110 {

	public static void main(String[] args) {
		TreeNode test = new TreeNode(1);
		test.left = new TreeNode(2);
		test.right = new TreeNode(3);
//		test.right.right = new TreeNode(3);

		test.left.left = new TreeNode(4);
		test.left.right = new TreeNode(5);
		test.right.left = new TreeNode(6);
//		test.right.right = new TreeNode(7);

		test.left.left.left = new TreeNode(8);
//		test.left.left.right = new TreeNode(4);
		boolean tt = isBalanced(test);
		System.out.println(tt);
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return height(root) != -1;
	}

	// first get left and right height using recursion, then see if there is a
	// unbalanced subtree exists, return false immediately if there is one, of not,
	// check if the height of left and right is no more different than 1
	public static int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int lH = height(node.left);
		if (lH == -1) {
			return -1;
		}
		int rH = height(node.right);
		if (rH == -1) {
			return -1;
		}
		if (lH - rH < -1 || lH - rH > 1) {
			return -1;
		}
		return Math.max(lH, rH) + 1;
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
