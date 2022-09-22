package easy;

public class ValidPalindrome2_680 {
	public static void main(String args[]) {
		String s = "abc";
		System.out.println(validPalindrome(s));
	}

	// need to have a helper function, will do it tomorrow
	public static boolean validPalindrome(String s) {
		int p1 = 0;
		int p2 = s.length() - 1;
		return helper(s, p1, p2, false);
	}

	public static boolean helper(String s, int p1, int p2, boolean boo) {
		if (p1 > p2) {
			return true;
		}
		if (s.charAt(p1) == s.charAt(p2)) {
			p1++;
			p2--;
			return helper(s, p1, p2, boo);
		} else if (boo) {
			return false;
		} else {
			return helper(s, p1, p2 - 1, true) || helper(s, p1 + 1, p2, true);
		}
	}
}
