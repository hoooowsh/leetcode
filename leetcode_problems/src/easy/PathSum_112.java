package easy;

public class PathSum_112 {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		boolean tt = hasPathSum(root, 1);
		System.out.println(tt);
	}

	// remember that definition of a leaf is left and right nodes are both null
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		int cur = targetSum - root.val;
		// if it is the leaf
		if (root.left == null && root.right == null) {
			return cur == 0;
		}
		return hasPathSum(root.left, cur) || hasPathSum(root.right, cur);
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
