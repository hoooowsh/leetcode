package medium;

public class DecodeWays_91 {
	public static void main(String[] args) {
		System.out.println(numDecodings2("110"));
	}

	public static int numDecodings(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		int result = helper(s, 0, false);
		return result;
	}

	public static int helper(String s, int index, Boolean isTwoDigit) {
		if (index > s.length() - 1) {
			return 0;
		}
		int cur = s.charAt(index) - '0';
		// if it is the first digit
		if (!isTwoDigit) {
			// not good if 0
			if (cur == 0) {
				return 0;
			} else {
				if (cur > 2) {
					return 1 + helper(s, index + 1, false);
				} else {
					return 1 + helper(s, index + 1, true) + helper(s, index + 1, false);
				}
			}
		}
		// if it is the second digit
		else {
			if (cur > 6) {
				return 0;
			} else if (cur == 0) {
				return helper(s, index + 1, false);
			} else {
				return 1 + helper(s, index + 1, false);
			}
		}
	}

	public static int numDecodings2(String s) {
		int[] arr = new int[s.length() + 1];
		if (s.charAt(0) - '0' == 0) {
			return 0;
		}
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 1; i < s.length(); i++) {
			int cur = s.charAt(i) - '0';
			if (cur == 0) {
				if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') == 0
						|| (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') > 26) {
					return 0;
				} else {
					arr[i + 1] = arr[i - 1];
					continue;
				}
			} else {
				// can
				if ((s.charAt(i - 1) - '0') * 10 + cur > 26) {
					arr[i + 1] = arr[i];
				} else if (s.charAt(i - 1) - '0' == 0) {
					arr[i + 1] = arr[i];
				} else {
					arr[i + 1] = arr[i] + arr[i - 1];
				}
			}
		}
		if (s.charAt(s.length() - 1) == '0') {
			return arr[arr.length - 1];
		}
		return Math.max(arr[arr.length - 1], arr[arr.length - 2]);
	}
}
