package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum_15 {
	public static void main(String[] args) {
		int[] test = { -1, 0, 1, 2, -1, -4 };
		int[] test2 = { 0, 0, 0 };
		threeSum2(test2);
	}

	// First brute force version, usign three loops
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		if (nums.length < 3) {
			return arr;
		}
		// first sort it
		Arrays.sort(nums);
		// add it to an arraylist for easier finding
		ArrayList<Integer> container = new ArrayList<Integer>();
		boolean twosame = false;
		for (int i = 0; i < nums.length; i++) {
			int num1 = nums[i];
			if (num1 > 0) {
				break;
			}
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j] && twosame == true) {
					continue;
				}
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				twosame = false;
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[k] == 0 - nums[i] - nums[j]) {
						List<Integer> templist = new ArrayList<Integer>();
						templist.add(nums[i]);
						templist.add(nums[j]);
						templist.add(nums[k]);
						arr.add(templist);
						if (nums[i] == nums[j]) {
							twosame = true;
						}
						break;
					}
				}
			}
		}
		return arr;
	}

	// Second version, first looping through all digits then using two pointer, one
	// from left for smaller int, one from right for bigger int.
	public static List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int sum = 0 - nums[i];
				// here becomes to two sum question
				int lo = i + 1;
				int hi = nums.length - 1;
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						/////////////////////////////////////////////////////////////////////
						// Remember here. It's all like two sum, but after finding a match,
						// need to go to next int that different than previous, that's why use
						// two while to find next integer
						/////////////////////////////////////////////////////////////////////
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
		return res;
	}
}
