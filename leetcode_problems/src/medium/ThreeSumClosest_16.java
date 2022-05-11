package medium;

import java.util.Arrays;

public class ThreeSumClosest_16 {
	public static void main(String[] args) {
		int[] test = { -1, 2, 1, -4 };
		threeSumClosest(test, 1);
	}

	// simple version, using same technique like 3sum, can be improved using some
	// math
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int sum = target - nums[i];
				// here becomes to two sum question
				int lo = i + 1;
				int hi = nums.length - 1;
				while (lo < hi) {
					if (nums[lo] + nums[hi] < sum) {
						int temp = nums[i] + nums[lo] + nums[hi];
						if (Math.abs(temp - target) < Math.abs(closest - target)) {
							closest = temp;
						}
						lo++;
					} else {
						int temp = nums[i] + nums[lo] + nums[hi];
						if (Math.abs(temp - target) < Math.abs(closest - target)) {
							closest = temp;
						}
						hi--;
					}
				}
			}
		}
		return closest;
	}
}
