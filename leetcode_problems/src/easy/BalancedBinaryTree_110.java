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
		return Math.abs(helper(1, root.left) - helper(1, root.right)) <= 1;
	}

	public static int helper(int deep, TreeNode node) {
		if (node == null) {
			return deep;
		}
		helper(deep + 1, node.left);
		helper(deep + 1, node.right);
		return deep;
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
