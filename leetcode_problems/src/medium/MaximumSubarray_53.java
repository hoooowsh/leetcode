package medium;

public class MaximumSubarray_53 {
	public static void main(String[] args) {
		int[] test = { -2, -1 };
		int tt = maxSubArray(test);
		System.out.println(tt);
	}

	// count for current max and then record it to another array, kind of DP
	public static int maxSubArray(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int result = nums[0];
		// this array records the max val for current
		int[] max = new int[nums.length];
		max[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max[i - 1] < 0) {
				max[i] = nums[i];
				if (max[i] > result) {
					result = max[i];
				}
				continue;
			}
			int cur = max[i - 1] + nums[i];
			if (cur > 0) {
				max[i] = cur;
				if (max[i] > result) {
					result = max[i];
				}
			} else {
				max[i] = nums[i];
				if (max[i] > result) {
					result = max[i];
				}
			}
		}
		return result;
	}

}
