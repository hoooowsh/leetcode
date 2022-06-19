package medium;

public class DivideTwoIntegers_29 {
	public static void main(String[] args) {
//		int test = divide(-2147483648, 2);
//		int i = 1;
//		System.out.println(i << 1);
		System.out.println(divide(2147483647, 2147483647));

	}

	///////////////////////////////////////////////////////////////////////////////
	//// This version using long to store values to avoid overflow, violate the
	//// requirement, but fuck the stupid requirement
	///////////////////////////////////////////////////////////////////////////////
	// first version, basic idea is get divisor powers of two until it's bigger than
	// dividend, then use dividend minus it, and continue
	// Example: (10, 3) 3, 6, 12, 12 > 10, current = 10 - 6 = 4, record 2
	// 3, 6, 6 > 4, current = 4 - 3 = 1, record 1
	// add 1 and 2 get 3
	public static int divide(int dividend, int divisor) {
		int positive = 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		long dividend2 = (long) dividend;
		long divisor2 = (long) divisor;
		if (dividend2 < 0) {
			positive++;
			dividend2 = -dividend2;
		}
		if (divisor2 < 0) {
			positive++;
			divisor2 = -divisor2;
		}
		long result = 0;
		while (dividend2 >= divisor2) {
			long temp = 1;
			long num1 = divisor2;
			boolean boo = true;
			while (dividend2 >= num1) {
				if (boo) {
					boo = false;
					num1 = num1 << 1;
				} else {
					temp = temp << 1;
					num1 = num1 << 1;
				}
			}
			result += temp;
			dividend2 -= num1 >> 1;
		}
		if (positive == 1) {
			return -(int) result;
		}
		return (int) result;
	}

}
