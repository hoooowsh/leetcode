package easy;

public class PowerofTwo_231 {

	public static void main(String args[]) {
		int test = 16;
		boolean tt = isPowerOfTwo(test);
	}

	public static boolean isPowerOfTwo(int n) {
		int num = 1;
		for (int i = 0; i < 32; i++) {
			if (n == num) {
				return true;
			} else if (n < num) {
				return false;
			} else {
				num <<= 1;
			}
		}
		return false;
	}
}
