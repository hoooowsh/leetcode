package easy;

import java.util.Arrays;

public class TwoSum_1 {
	public static void main(String[] args) {

	}

	// First sort the array, then using two pointers, one from smaller integers one
	// from larger integers, add them together see if the result equals to target.
	// If match, find the index of these two integers from the original array and
	// return them.
	public int[] twoSum(int[] nums, int target) {
		int[] SortingArray = nums.clone();
		int[] result = new int[2];
		Arrays.sort(SortingArray);
		int head = 0;
		int tail = nums.length - 1;
		while (head != tail) {
			if (SortingArray[head] + SortingArray[tail] == target) {
				int counting = 0;
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == SortingArray[head] || nums[j] == SortingArray[tail]) {
						result[counting] = j;
						counting++;
						if (counting == 2) {
							break;
						}
					}
				}
				break;
			} else {
				if (SortingArray[head] + SortingArray[tail] < target) {
					head++;
				} else {
					tail--;
				}
			}
		}
		return result;
	}
}
