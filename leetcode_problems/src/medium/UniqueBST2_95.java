package medium;

import java.util.ArrayList;
import java.util.List;

import easy.BalancedBinaryTree_110.TreeNode;

public class UniqueBST2_95 {
	public static void main(String args[]) {

	}

	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> result = new ArrayList<>();
		return result;
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
