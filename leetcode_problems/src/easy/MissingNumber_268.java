package easy;

public class MissingNumber_268 {

	public static void main(String args[]) {
		int[] test = { 1, 2 };
		missingNumber(test);
	}

	public static int missingNumber(int[] nums) {
		int len = nums.length + 1;
		int last = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= nums.length) {
				if (nums[i] == nums.length) {
					last += len;
				} else {
					int temp = nums[i] - len;
					if (temp == nums.length) {
						last += len;
						continue;
					}
					nums[temp] += len;
				}
			} else {
				nums[nums[i]] += len;
			}
		}
		if (last == 0) {
			return nums.length;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < len) {
				return i;
			}
		}
		return 0;
	}
}
