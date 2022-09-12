package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class StepbyStepDirectionsFromBinaryTreeNodetoAnother_2096 {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(4);
		String tt = getDirections(root, 3, 6);
		System.out.println(tt);
	}

	public static String getDirections(TreeNode root, int startValue, int destValue) {
		StringBuilder pa = new StringBuilder();
		StringBuilder pb = new StringBuilder();
		dfs(root, startValue, pa);
		dfs(root, destValue, pb);
		int counter = 0;
		for (int i = 0; i < pa.length(); i++) {
			if (i >= pb.length()) {
				break;
			} else {
				if (pb.charAt(i) == pa.charAt(i)) {
					counter++;
				} else {
					break;
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < pa.length() - counter; i++) {
			result.append("U");
		}
		result.append(pb.substring(counter, pb.length()));

		return result.toString();
	}

	// very useful technique for recursive version of dfs, using a boolean to tell
	// if the target exist in the tree
	public static boolean dfs(TreeNode cur, int target, StringBuilder sb) {
		if (cur.val == target) {
			return true;
		}
		if (cur.left != null && dfs(cur.left, target, sb)) {
			sb.insert(0, "L");
		} else if (cur.right != null && dfs(cur.right, target, sb)) {
			sb.insert(0, "R");
		}
		return sb.length() > 0;
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
