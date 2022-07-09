package easy;

public class PlusOne_66 {
	public int[] plusOne(int[] digits) {
		int add1 = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + add1;
			if (temp == 10) {
				add1 = 1;
				digits[i] = 0;
			} else {
				add1 = 0;
				digits[i] = temp;
			}
		}
		if (add1 == 1) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			for (int i = 1; i < result.length; i++) {
				result[i] = digits[i - 1];
			}
			return result;
		} else {
			return digits;

		}
	}
}
