package easy;

public class SumofLeftLeaves_404 {
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

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int test = sumOfLeftLeaves(root);
		System.out.println(test);
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		return helper(root.left, true) + helper(root.right, false);
	}

	public static int helper(TreeNode cur, Boolean isLeft) {
		if (cur == null) {
			return 0;
		}
		if (isLeft && cur.left == null && cur.right == null) {
			return cur.val;
		}

		if (cur.left != null && cur.right != null) {
			return helper(cur.left, true) + helper(cur.right, false);
		} else if (cur.left != null) {
			return helper(cur.left, true);
		} else if (cur.right != null) {
			return helper(cur.right, false);
		} else {
			return 0;
		}
	}
}
