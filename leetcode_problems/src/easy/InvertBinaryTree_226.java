package easy;

public class InvertBinaryTree_226 {
	public static void main(String args[]) {

	}

	public static TreeNode invertTree(TreeNode root) {
		TreeNode head = root;
		helper(root);
		return head;
	}

	public static void helper(TreeNode node) {
		if (node == null) {
			return;
		}
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		helper(node.left);
		helper(node.right);
	}

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
}
