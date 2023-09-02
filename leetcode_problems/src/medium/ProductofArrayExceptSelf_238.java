package medium;

public class ProductofArrayExceptSelf_238 {
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		for (int i = 0; i < left.length; i++) {
			if (i == 0) {
				left[i] = nums[i];
			} else {
				left[i] = left[i - 1] * nums[i];
			}
		}
		for (int i = right.length - 1; i >= 0; i--) {
			if (i == right.length - 1) {
				right[i] = nums[i];
			} else {
				right[i] = right[i + 1] * nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				nums[i] = right[i + 1];
			} else if (i == nums.length - 1) {
				nums[i] = left[i - 1];
			} else {
				nums[i] = left[i - 1] * right[i + 1];
			}
		}
		return nums;
	}
}
