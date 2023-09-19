package medium;

public class BinaryTreePruning_814 {
	public class TreeNode {
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

	public TreeNode pruneTree(TreeNode root) {
		boolean test = hasOne(root);
		if (!test) {
			return null;
		}
		return root;
	}

	public static boolean hasOne(TreeNode cur) {
		if (cur == null) {
			return false;
		}
		boolean left = hasOne(cur.left);
		boolean right = hasOne(cur.right);
		if (!left) {
			cur.left = null;
		}
		if (!right) {
			cur.right = null;
		}
		if (cur.val == 1 || left || right) {
			return true;
		} else {
			return false;
		}
	}
}
