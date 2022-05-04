package medium;

public class ValidateBST_98 {
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
		TreeNode p = new TreeNode(2);
		p.left = new TreeNode(1);
		p.right = new TreeNode(3);
		isValidBST(p);
	}

	
	
	static boolean glo = true;
	static TreeNode prev;
	public static boolean isValidBST(TreeNode root) {
		helper(root);
		boolean test = glo;
		return test;
	}
	// always use this inorder traversal for BST!!
	public static void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		if (prev != null && prev.val > root.val) {
			glo = false;
		}
		prev = root;
		helper(root.right);
	}

}
