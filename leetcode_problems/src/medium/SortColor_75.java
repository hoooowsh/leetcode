package medium;

public class SortColor_75 {
	public static void main(String args[]) {
		int[] test = { 2, 0, 2, 1, 1, 0 };
		sortColors2(test);
	}

	// approach only use constant extra space, stupid shit, i can just swap it
	public static void sortColors(int[] nums) {
		int pointer_0 = 0;
		int pointer_1 = 0;
		int pointer_2 = 0;

		for (int i = 0; i < nums.length; i++) {
			// if current is 0
			if (nums[i] == 0) {
				// if 0 pointer same with counter, just push all pointers back and do nothing
				if (pointer_0 == i) {
					nums[pointer_0] = 0;
					pointer_0++;
					pointer_1++;
					pointer_2++;
					continue;
				}
				// if current 0 pointer is 1, need to add one to pointer_1
				else if (nums[pointer_0] == 1) {
					// if current 1 pointer is 2, need to add two to pointer_2
					if (nums[pointer_1] == 2) {
						nums[pointer_0] = 0;
						nums[pointer_1] = 1;
						nums[pointer_2] = 2;
						pointer_0++;
						pointer_1++;
						pointer_2++;
						continue;
					}
					// else do nothing
					else {
						nums[pointer_0] = 0;
						nums[pointer_1] = 1;
						pointer_0++;
						pointer_1++;
						pointer_2++;
						continue;
					}
				}
				// if current 0 pointer is 2, need to add 2
				else {
					nums[pointer_0] = 0;
					nums[pointer_2] = 2;
					pointer_0++;
					pointer_1++;
					pointer_2++;
					continue;
				}
			} else if (nums[i] == 1) {
				// do nothing but push 1 and 2 pointer
				if (pointer_1 == i) {
					nums[pointer_1] = 1;
					pointer_1++;
					pointer_2++;
					continue;
				} else if (nums[pointer_1] == 2) {
					nums[pointer_1] = 1;
					nums[pointer_2] = 2;
					pointer_1++;
					pointer_2++;
					continue;
				} else {
					nums[pointer_1] = 1;
					pointer_1++;
					pointer_2++;
					continue;
				}
			} else {
				nums[pointer_2] = 2;
				pointer_2++;
			}
		}
	}

	// approach that just swap it
	public static void sortColors2(int[] nums) {
		int pointer_0 = 0;
		int pointer_1 = 0;
		int pointer_2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				swap(nums, pointer_0, i);
				if (pointer_0 != pointer_1) {
					swap(nums, pointer_1, i);
				}
				pointer_0++;
				pointer_1++;
				pointer_2++;
			} else if (nums[i] == 1) {
				swap(nums, pointer_1, i);
				pointer_1++;
				pointer_2++;
			} else {
				pointer_2++;
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return;

	}
}
