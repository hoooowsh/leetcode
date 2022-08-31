package medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
	public static void main(String[] args) {

	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if (root == null) {
			return result;
		}
		helper(result, root, 0);
		for (int i = 0; i < result.size(); i++) {
			if (i % 2 != 0) {
				for (int j = 0; j < result.get(i).size() / 2; j++) {
					int temp = result.get(i).get(j);
					result.get(i).set(j, result.get(i).get(result.get(i).size() - 1 - j));
					result.get(i).set(result.get(i).size() - 1 - j, temp);
				}
			}
		}
		return result;
	}

	public static void helper(List<List<Integer>> result, TreeNode node, int deep) {
		if (node == null) {
			return;
		}
		if (result.size() <= deep) {
			result.add(deep, new LinkedList<Integer>());
		}
		result.get(deep).add(node.val);
		helper(result, node.left, deep + 1);
		helper(result, node.right, deep + 1);
		return;
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
