package easy;

public class PowerofThree_326 {
	public static void main(String[] args) {

	}

	public boolean isPowerOfThree(int n) {
		while (n >= 3) {
			if (n % 3 == 0) {
				n = n / 3;
			} else {
				return false;
			}
		}
		if (n == 1) {
			return true;
		}
		return false;
	}
}
