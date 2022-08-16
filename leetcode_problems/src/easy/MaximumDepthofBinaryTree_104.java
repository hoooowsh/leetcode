package easy;

import java.util.Stack;


public class MaximumDepthofBinaryTree_104 {

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
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
	}

	
	// simple recursive version
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// simple iteration version
	public static int maxDepth2(TreeNode root) {
		if (root == null)
			return 0;

		int max = 1;

		Stack<TreeNode> nodes = new Stack<>();
		Stack<Integer> depths = new Stack<>();

		nodes.push(root);
		depths.push(1);

		while (!nodes.empty()) {
			TreeNode curr = nodes.pop();
			int depth = depths.pop();

			if (curr.left == null && curr.right == null) {
				max = Math.max(max, depth);
			}

			if (curr.right != null) {
				nodes.push(curr.right);
				depths.push(depth + 1);
			}
			if (curr.left != null) {
				nodes.push(curr.left);
				depths.push(depth + 1);
			}
		}

		return max;

	}

}
