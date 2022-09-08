package medium;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
	public static void main(String[] args) {

	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode head = new TreeNode(0);
		return head;
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
