package hard;

import java.util.HashSet;

public class FirstMissingPositive_41 {
	public static void main(String[] args) {
		int[] test = { 2, 2 };
		int tt = firstMissingPositive2(test);
		System.out.println(tt);
	}

	// easy version, store all elements in a hashset and find the smallest
	public static int firstMissingPositive(int[] nums) {
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				hash.add(nums[i]);
			}
		}
		for (int i = 1; i <= nums.length + 1; i++) {
			if (!hash.contains(i)) {
				return i;
			}
		}
		return 0;
	}

	// there must exist an element that smaller than nums length satisfies the
	// condition, using swap. Faster than previouse version
	public static int firstMissingPositive2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums.length || nums[i] <= 0) {
				nums[i] = -1;
				continue;
			} else {
				// if the current position is good already
				if (nums[i] - 1 == i) {
					continue;
				}
				// if the position that needs to swap is good already, meaning duplicate
				if (nums[nums[i] - 1] == nums[i]) {
					nums[i] = -1;
					continue;
				}
				// t is position
				int t = nums[i] - 1;
				// t2 is var in that position
				int t2 = nums[nums[i] - 1];
				swap(nums, nums[i] - 1, i);
				i--;
			}
		}
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				result = i + 1;
				break;
			}
		}
		if (result == 0) {
			result = nums.length + 1;
		}
		return result;
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
