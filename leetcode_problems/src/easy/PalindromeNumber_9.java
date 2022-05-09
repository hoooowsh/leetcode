package easy;

public class PalindromeNumber_9 {
	public static void main(String[] args) {

	}

	// first version, using string
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String str = Integer.toString(x);
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	// second version, using math. First reverse the integer and see of the reversed
	// int equals to original int
	public boolean isPalindrome2(int x) {
		if (x < 0) {
			return false;
		}
		int y = x;
		int res = 0;
		while (y != 0) {
			res = res * 10 + y % 10;
			y /= 10;
		}
		return x == res;
	}
}
