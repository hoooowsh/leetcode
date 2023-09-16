package medium;

public class SubarraySumEqualK_560 {
	public static void main(String[] args) {

	}

	public int subarraySum(int[] nums, int k) {
		int result = 0;
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++) {
			sum[i] = nums[i - 1] + sum[i - 1];
		}

		for (int i = 1; i < sum.length; i++) {
			for (int j = i; j < sum.length; j++) {
				if (sum[j] - sum[i - 1] == k) {
					result++;
				}
			}
		}
		return result;
	}
}
