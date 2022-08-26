package medium;

public class UniqueBST_96 {
	public static void main(String[] args) {
		int test = numTrees(2);
		System.out.println(test);
	}

	// using dynamic programming, the total tree number for current node as root is
	// left side possible subtree num times right side possible subtree num
	public static int numTrees(int n) {
		if (n == 0) {
			return 0;
		}
		if (n < 2) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[i - j - 1] * dp[j];
			}
		}

		return dp[n];
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
