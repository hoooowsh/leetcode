package easy;

public class MinimumDepthofBT_111 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int test = minDepth(root);
		System.out.println(test);
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

	// for getting the depth of a tree, do it in this order
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return right + 1;
		}
		if (root.right == null) {
			return left + 1;
		}
		return Math.min(left, right) + 1;
	}

}
