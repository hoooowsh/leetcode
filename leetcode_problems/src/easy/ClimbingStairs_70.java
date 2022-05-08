package easy;

public class ClimbingStairs_70 {
	public static void main(String[] args) {
	}

	// DP
	// Basic idea is while considering ith step, there are total two ways to achieve
	// that step. Like Fibonacci number
	// case 1: take a step that contains 1 stair from i-1 step
	// case 2: take a step that contains 2 stairs from i-2 step
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	
	
	// same as above, just using a recursion version
	public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
