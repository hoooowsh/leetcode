package easy;

public class LongestCommonPrefix_14 {
	public static void main(String[] args) {
	}

	// first version
	public String longestCommonPrefix(String[] strs) {
		String result = "";
		if (strs.length == 0) {
			return result;
		}

		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 0; j < strs.length; j++) {
				if (strs[j].length() <= i) {
					return result;
				}
				if (strs[j].charAt(i) != strs[0].charAt(i)) {
					return result;
				}
			}
			result += strs[0].charAt(i);
		}
		return result;
	}

	// second faster version calling indexof method
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
			}
		}
		return pre;
	}
}
