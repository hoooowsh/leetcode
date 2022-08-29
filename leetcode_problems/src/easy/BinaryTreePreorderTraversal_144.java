package easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
	public static void main(String[] args) {

	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		helper(result, root);
		return result;
	}

	public static void helper(List<Integer> result, TreeNode node) {
		if (node == null) {
			return;
		}
		result.add(node.val);
		helper(result, node.left);
		helper(result, node.right);
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
