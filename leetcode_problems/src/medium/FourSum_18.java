package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
	public static void main(String[] args) {
	}

	// same idea with threesum, just using one more loop
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length < 4) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int lo = j + 1;
				int hi = nums.length - 1;
				int sum = target - nums[i] - nums[j];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						result.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1]) {
							lo++;
						}
						while (lo < hi && nums[hi] == nums[hi - 1]) {
							hi--;
						}
						lo++;
						hi--;
						continue;
					}
					if (nums[lo] + nums[hi] < sum) {
						lo++;
					} else {
						hi--;
					}
				}

			}
		}
		return result;
	}
}
