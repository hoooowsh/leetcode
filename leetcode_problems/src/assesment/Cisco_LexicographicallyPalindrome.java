package assesment;

public class Cisco_LexicographicallyPalindrome {

	public static void main(String args[]) {
		String test1 = "ABCCBA";
		String test2 = "YABCCBAZ";
		String test3 = "ABC";
		String test4 = "ABCBA";
		String test5 = "AAAAAAAAAABCCBA";
//		System.out.println(LongestPalindrome(test1));

	}

	public static void LongestPalindrome(String inputStr) {
		// Write your code here
		if (inputStr.length() < 2) {
			System.out.println(inputStr);
		}
		String result = "";
		int maxlen = 0;
		for (int i = 0; i < inputStr.length(); i++) {
			// this first check even palindrome
			int l = i;
			int r = i + 1;
			while (l >= 0 && r < inputStr.length() && inputStr.charAt(l) == inputStr.charAt(r)) {
				l--;
				r++;
			}
			l++;
			r--;
			// check if the current is longer
			if (r - l + 1 > maxlen) {
				maxlen = r - l + 1;
				result = inputStr.substring(l, r + 1);
			}
			// if same length check alpha
			if (r - l == maxlen) {
				String temp = inputStr.substring(l, r + 1);
				for (int j = 0; j < result.length(); j++) {
					if (result.charAt(j) - '0' < temp.charAt(j) - '0') {
						break;
					} else if (temp.charAt(j) - '0' < result.charAt(j) - '0') {
						result = temp;
						maxlen = r - l;
					} else {
						continue;
					}
				}
			}

			// Then check odd palindrome
			l = i;
			r = i;
			while (l >= 0 && r < inputStr.length() && inputStr.charAt(l) == inputStr.charAt(r)) {
				l--;
				r++;
			}
			l++;
			r--;
			// check if the current is longer
			if (r - l + 1 > maxlen) {
				maxlen = r - l + 1;
				result = inputStr.substring(l, r + 1);
			}
			// if same length check alpha
			if (r - l == maxlen) {
				String temp = inputStr.substring(l, r + 1);
				for (int j = 0; j < result.length(); j++) {
					if (result.charAt(j) - '0' < temp.charAt(j) - '0') {
						break;
					} else if (temp.charAt(j) - '0' < result.charAt(j) - '0') {
						result = temp;
						maxlen = r - l;
					} else {
						continue;
					}
				}
			}
		}
		if (maxlen == 1) {
			System.out.println("None");
		} else {
			System.out.println(result);
		}
	}

}
