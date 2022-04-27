package medium;

public class LongestPalindromicSubstring_5 {
	public static void main(String[] args) {
	}

	public String longestPalindrome(String s) {
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

	public String helper(String s, int i, int j) {
		for (; i >= 0 && j < s.length(); i--, j++) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
		}
		return s.substring(i + 1, j);
	}
}
