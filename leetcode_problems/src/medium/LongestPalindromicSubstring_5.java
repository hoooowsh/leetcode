package medium;

public class LongestPalindromicSubstring_5 {
	public static void main(String[] args) {
		String test = longestPalindrome3("ab");
		System.out.println(test);
	}

	// this version is using DP, dp[i][j] true or false meaning substring(i,j) is
	// palindrome or not
	public static String longestPalindrome3(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}
		String result = "";
		boolean[][] dp = new boolean[len][len];
		int max = 0;
		for (int j = 0; j < len; j++) {
			for (int i = 0; i <= j; i++) {
				//////////////////////////////////////////////////
				// j - i < 3 先判定，所以当i=0, j=0时，dp[i + 1][j - 1] == true 不会有error
				//////////////////////////////////////////////////
				if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] == true)) {
					dp[i][j] = true;
					if (j - i + 1 > max) {
						max = j - i + 1;
						result = s.substring(i, j + 1);
					}
				} else {
					dp[i][j] = false;
				}

			}
		}
		return result;
	}

	// This version is brute force, start with one or two char as middle and then
	// search towards left and right
	public static String longestPalindrome(String s) {
		String max = "";
		for (int i = 0; i < s.length(); i++) {
			String str1 = helper(s, i, i);
			String str2 = helper(s, i, i + 1);
			if (str1.length() > max.length()) {
				max = str1;
			}
			if (str2.length() > max.length()) {
				max = str2;
			}
		}
		return max;
	}

	public static String helper(String s, int i, int j) {
		for (; i >= 0 && j < s.length(); i--, j++) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
		}
		return s.substring(i + 1, j);
	}

	// This version is also slow brute force, using one char or two char be in the
	// middle, then search towards left and right
	public static String longestPalindrome2(String s) {
		if (s.length() == 1) {
			return s;
		}
		if (s.equals("")) {
			return "";
		}
		String result = s.charAt(0) + "";
		int max = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			int lo = i;
			int hi = i + 1;
			if (hi < s.length()) {
				// for single mid
				result = helper2(s, lo, lo, result);
				// for double mid
				result = helper2(s, lo, hi, result);
			} else {
				// for single mid
				result = helper2(s, lo, lo, result);
			}
		}

		return result;
	}

	public static String helper2(String s, int lo, int hi, String result) {
		if (s.charAt(lo) != s.charAt(hi)) {
			return result;
		}
		String temp = s.substring(lo, hi + 1);
		boolean first = false;
		while (lo >= 0 && hi <= s.length() - 1) {
			// if not in hash, and it satisfies the property, add it to hash
			if (s.charAt(lo) == s.charAt(hi)) {
				temp = s.substring(lo, hi + 1);
				lo--;
				hi++;
				continue;
			}
			// if not in hash, and it not satisfies the property, break and return
			else {
				break;
			}
		}
		if (temp.length() > result.length()) {
			return temp;
		} else {
			return result;
		}
	}
}
