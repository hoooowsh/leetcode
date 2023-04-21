package easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths_257 {
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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		List<String> test = binaryTreePaths(root);
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new LinkedList<String>();
		if (root == null) {
			return result;
		}
		helper(root, result, "");
		return result;
	}

	public static void helper(TreeNode cur, List<String> result, String str) {
		if (cur.left == null && cur.right == null) {
			str += cur.val;
			result.add(str);
			return;
		}
		if (cur.left == null) {
			helper(cur.right, result, str + cur.val + "->");
		} else if (cur.right == null) {
			helper(cur.left, result, str + cur.val + "->");
		} else {
			helper(cur.left, result, str + cur.val + "->");
			helper(cur.right, result, str + cur.val + "->");
		}
	}
}
