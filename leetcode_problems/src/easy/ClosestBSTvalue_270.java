package easy;

public class ClosestBSTvalue_270 {
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
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(3);
		int test = closestValue(root, 3.71);
		System.out.println(test);
	}

	public static int closestValue(TreeNode root, double target) {
		if (root == null) {
			return 0;
		}
		int result = helper(root, target, Integer.MAX_VALUE, Integer.MIN_VALUE);
		return result;
	}

	public static int helper(TreeNode cur, double target, int upper_bond, int lower_bond) {
		// if cur is null, closest is calculated already
		if (cur == null) {
			double upper = Math.abs((double) upper_bond - target);
			double lower = Math.abs((double) lower_bond - target);
			if (upper < lower) {
				return upper_bond;
			} else {
				return lower_bond;
			}
		}
		// if it is target, return it
		if (Math.abs((double) cur.val - target) < 0.5) {
			return cur.val;
		}
		// if current val is bigger than target and smaller than upper_bond, update it
		if (cur.val > target) {
			if (cur.val < upper_bond) {
				upper_bond = cur.val;
			}
			return helper(cur.left, target, upper_bond, lower_bond);
		}
		// if current val is smaller than target and bigger than lower_bond, update it
		else {
			if (cur.val > lower_bond) {
				lower_bond = cur.val;
			}
			return helper(cur.right, target, upper_bond, lower_bond);
		}
	}
}
