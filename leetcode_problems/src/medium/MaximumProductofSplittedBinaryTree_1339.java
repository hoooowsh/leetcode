package medium;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductofSplittedBinaryTree_1339 {

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

	public int maxProduct(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		int rootval = root.val;
		List<Long> list = new ArrayList<Long>();
		long total = 0;
		if (root.left == null || root.right == null) {
			total = dfs(root, list);
			list.add(list.get(list.size() - 1) + rootval);
		} else {
			total = dfs(root, list);
			list.add(list.get(list.size() - 1) + rootval);
			list.add(list.get(list.size() - 2) + rootval);
		}
		double min = Double.MAX_VALUE;
		long sub = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			double temp = Math.abs(list.get(i) - ((double) total) / 2);
			if (temp < min) {
				min = temp;
				sub = list.get(i);
			}
		}
		long test = sub;
		System.out.println(test);
		System.out.println(total);
		return (int) (sub * (total - sub) % 1000000007);
	}

	public long dfs(TreeNode root, List<Long> list) {
		if (root == null) {
			return 0;
		}
		// get the left and right subtree value
		long left = dfs(root.left, list);
		long right = dfs(root.right, list);
		// store the left subtree value and right subtree value in the list
		if (left != 0) {
			list.add(left);
		}
		if (right != 0) {
			list.add(right);
		}
		return left + right + (long) root.val;
	}
}
