package medium;

public class DecodeWays_91 {
	public static void main(String[] args) {
		System.out.println(numDecodings("110"));
	}

	public static int numDecodings(String s) {
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
