package medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {
	public static void main(String[] args) {
		List<String> arr = restoreIpAddresses("0000");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	// brute force version, also kind of backtracking?
	public static List<String> restoreIpAddresses(String s) {
		ArrayList<String> arr = new ArrayList<String>();
		if (s.length() > 12 || s.length() < 4) {
			return arr;
		}
		for (int a = 0; a < 3; a++) {
			String temp1 = s.substring(0, a + 1);
			for (int b = 0; b < 3; b++) {
				if (a + b + 2 > s.length()) {
					break;
				}
				String temp2 = s.substring(a + 1, b + a + 2);
				for (int c = 0; c < 3; c++) {
					if (a + b + c + 3 > s.length()) {
						break;
					}
					String temp3 = s.substring(b + a + 2, c + b + a + 3);
					for (int d = 0; d < 3; d++) {
						if (a + b + c + d + 4 > s.length()) {
							break;
						}
						String temp4 = s.substring(c + b + a + 3, d + c + b + a + 4);
						if (a + b + c + d + 4 != s.length()) {
							continue;
						}
						if (temp1.charAt(0) == '0' && temp1.length() != 1
								|| temp2.charAt(0) == '0' && temp2.length() != 1
								|| temp3.charAt(0) == '0' && temp3.length() != 1
								|| temp4.charAt(0) == '0' && temp4.length() != 1 || Integer.parseInt(temp1) > 255
								|| Integer.parseInt(temp2) > 255 || Integer.parseInt(temp3) > 255
								|| Integer.parseInt(temp4) > 255) {
							break;
						}
						String str = temp1 + "." + temp2 + "." + temp3 + "." + temp4;
						arr.add(str);
					}
				}
			}
		}
		return arr;
	}

	// second version, using stringbuilder can be faster, the idea is the same but
	// using recursion for this one
	public static List<String> restoreIpAddresses2(String s) {
		List<String> arr = new ArrayList<>();
		if (s.length() > 12 || s.length() < 4) {
			return arr;
		}
		helper2(arr, new StringBuilder(), s, 0, 0);
		return arr;
	}

	public static void helper2(List<String> res, StringBuilder temp, String s, int start, int count) {
		// if we are at the end and added 4 elements, add to result
		if (start == s.length() && count == 4) {
			res.add(temp.toString());
		}
		// if we are not at the end and already has 4 elements-> invalid
		else if (count == 4)
			return;

		for (int i = start; i < s.length(); i++) {
			String curr = s.substring(start, i + 1);
			int value = Integer.parseInt(curr);
			// check whether the number is like "0010" or "00";
			if (curr.length() > 1 && curr.charAt(0) == '0') {
				return;
			}
			// out of range
			if (value > 255) {
				return;
			}
			// less or equal to 255
			if (value <= 255 && value >= 0) {
				// Backtracking
				StringBuilder rollback = new StringBuilder(temp);
				temp.append(s.substring(start, i + 1));
				if (count < 3)
					temp.append(".");

				helper2(res, temp, s, i + 1, count + 1);
				// Rollback to previous state
				temp = rollback;
			}
		}
	}
}
