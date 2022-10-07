package assesment;

public class Cisco_LexicographicallyPalindrome {

	public static void main(String args[]) {
		String test1 = "ABCCBA";
		String test2 = "YABCCBAZ";
		String test3 = "ABC";
		String test4 = "ABCBA";
		String test5 = "AAAAAAAAAABCCBA";
		System.out.println(LongestPalindrome(test1));

	}

	public static String LongestPalindrome(String s) {
		// return None if too short
		if (s.length() < 2) {
			return "None";
		}
		String result = "";
		int maxlen = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			// current in index i
			int l = i;
			int r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				l--;
				r++;
			}
			l++;
			r--;
			// if the current palindrome is longer than previous
			if (r - l + 1 > maxlen) {
				maxlen = r - l + 1;
				result = s.substring(l, r + 1);
				continue;
			}
			// if they have same length, check lexicographically order
			if (r - l == maxlen) {
				String temp = s.substring(l, r);
				for (int j = 0; j < result.length(); j++) {
					if (result.charAt(j) - '0' < temp.charAt(j) - '0') {
						break;
					} else if (result.charAt(j) - '0' > temp.charAt(j) - '0') {
						result = temp;
						maxlen = r - l;
					} else {
						continue;
					}
				}
			}
		}
		if (result == "") {
			return "None";
		}
		return result;
	}

}
