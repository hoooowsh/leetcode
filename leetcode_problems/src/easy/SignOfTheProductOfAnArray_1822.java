package easy;

public class SignOfTheProductOfAnArray_1822 {
	public static void main(String[] args) {

	}

	public int arraySign(int[] nums) {
		int neg = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				return 0;
			}
			if (nums[i] < 0) {
				neg++;
			}
		}
		if (neg % 2 != 0) {
			return -1;
		}
		return 1;
	}
}
