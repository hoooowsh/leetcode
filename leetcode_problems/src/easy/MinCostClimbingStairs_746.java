package easy;

public class MinCostClimbingStairs_746 {
	public static void main(String[] args) {
		int[] test = { 10, 15, 20 };
		int[] test2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs3(test2));
	}

	public static int minCostClimbingStairs3(int[] cost) {
		int[][] dp = new int[cost.length + 1][2];
		for (int i = 0; i < dp.length; i++) {
			if (i == 0) {
				dp[0][0] = cost[0];
				dp[0][1] = Integer.MAX_VALUE;
				continue;
			}
			if (i == 1) {
				dp[1][0] = cost[0] + cost[1];
				dp[1][1] = cost[1];
				continue;
			}
			if (i == dp.length - 1) {
				dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
				dp[i][1] = Math.min(dp[i - 2][0], dp[i - 2][1]);
				continue;
			} else {
				dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i];
				dp[i][1] = Math.min(dp[i - 2][0], dp[i - 2][1]) + cost[i];

			}
		}
		return Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]);
	}

	public static int minCostClimbingStairs(int[] cost) {
		if (cost.length == 2) {
			return Math.min(cost[0], cost[1]);
		}
		int[] result = new int[cost.length];
		result[0] = cost[0];
		result[1] = cost[1];
		for (int i = 2; i < result.length; i++) {
			result[i] = Math.min(result[i - 2] + cost[i], result[i - 1] + cost[i]);
		}
		return Math.min(result[result.length - 1], result[result.length - 2]);
	}

	public static int minCostClimbingStairs2(int[] cost) {
		for (int i = 2; i < cost.length; i++) {
			cost[i] = Math.min(cost[i - 2] + cost[i], cost[i - 1] + cost[i]);
		}
		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}
}
