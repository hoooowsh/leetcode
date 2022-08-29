package easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
	public static void main(String[] args) {

	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		helper(result, root);
		return result;
	}

	public static void helper(List<Integer> result, TreeNode node) {
		if (node == null) {
			return;
		}
		helper(result, node.left);
		helper(result, node.right);
		result.add(node.val);
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
