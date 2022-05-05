package easy;

import java.util.ArrayList;
import java.util.List;

public class BTInorderTraversal_94 {
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

	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		helper(root, list);
		return list;
	}

	public static void helper(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		helper(root.left, list);
		helper(root.right, list);
	}
}
