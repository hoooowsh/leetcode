package easy;

public class MinCostClimbingStairs_746 {
	public static void main(String[] args) {
		int[] test = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs(test));
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
