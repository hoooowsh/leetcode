package medium;

public class DivideTwoIntegers_29 {
	public static void main(String[] args) {
		int test = divide(-2147483648, 2);
		System.out.println(test);
	}

	// first version, basic idea is get divisor powers of two until it's bigger than
	// dividend, then use dividend minus it, and continue
	// Example: (10, 3) 3, 6, 12, 12 > 10, current = 10 - 6 = 4, record 2
	// 3, 6, 6 > 4, current = 4 - 3 = 1, record 1
	// add 1 and 2 get 3
	public static int divide(int dividend, int divisor) {
		int result = 0;
		return result;
	}

}
