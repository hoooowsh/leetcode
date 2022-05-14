package medium;

import java.util.Arrays;

public class NextPermutation_31 {
	public static void main(String[] args) {
		int[] test = { 1, 3, 2 };
		nextPermutation(test);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}

	// Searching from last to beginning, if in increasing order, swap the last two
	// digits. If in decreasing order, find the index of a NUM that start changing
	// to increasing, from that index searching back for a digit that bigger than
	// NUM but is the smallest from the right half, swap them and resort after NUM
	public static void nextPermutation(int[] nums) {
		if (nums.length < 2) {
			return;
		}
		// if in increasing order, swap the last two digits
		if (nums[nums.length - 2] < nums[nums.length - 1]) {
			int temp = nums[nums.length - 2];
			nums[nums.length - 2] = nums[nums.length - 1];
			nums[nums.length - 1] = temp;
			return;
		}
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				int temp = nums[i - 1];
				int smallest = Integer.MAX_VALUE;
				int smallestidx = i;
				for (int j = i; j < nums.length; j++) {
					if (nums[j] > temp && nums[j] < smallest) {
						smallest = nums[j];
						smallestidx = j;
					}
				}
				nums[i - 1] = nums[smallestidx];
				nums[smallestidx] = temp;
				Arrays.sort(nums, i, nums.length);
				return;
			}
		}
		Arrays.sort(nums);
		return;
	}
}
