package easy;

public class PowerofFour_342 {
	public static void main(String[] args) {

	}

	// bit manipulation:
	// 4^0 -> 1
	// 4^2 -> 100
	// 4^3 -> 10000
	// so for example, do 10000 - 1, get 1111, then do an and operation, if the
	// number is power of four, then the result should be 0

	// edge case is that the number should only have one 1 in odd position, need to
	// make sure
	// 3 is 11
	// keep left shifting this n, and for each time, do an and operation with 3, if
	// the result is 0, it means that the last two bit of n is 00
	public boolean isPowerOfFour(int n) {
		if (n < 1) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		if ((n & (n - 1)) != 0) {
			return false;
		}
		while ((3 & n) == 0) {
			n >>= 2;
		}
		return n == 1;
	}
}
