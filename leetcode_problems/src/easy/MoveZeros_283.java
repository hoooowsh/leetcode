package easy;

import java.util.Arrays;

public class MoveZeros_283 {
	public static void main(String args[]) {
		int[] arr = { 0, 1, 0, 3, 12 };
		moveZeroes(arr);
	}

	public static void moveZeroes(int[] nums) {
		int p1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (p1 < i) {
					p1 = i;
				}
				for (int j = p1; j < nums.length; j++) {
					if (nums[j] != 0) {
						nums[i] = nums[j];
						nums[j] = 0;
						p1 = j;
						break;
					}
				}
			}
		}
	}
}
