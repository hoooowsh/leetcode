package hard;

public class RegularExpressionMatching_10 {
	public static void main(String[] args) {
		isMatch("aaa", ".*");
		System.out.println();
	}

	// This version using recursion, basically it has two cases for this question.
	// Case 1: the next char is *
	// Case 2: the next char is not *
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		// case 1, with *
		if (p.length() > 1 && p.charAt(1) == '*') {
			// if * stands for 0
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				return isMatch(s.substring(1), p);
			}
			return false;
		}
		// case 2, not *
		else {
			if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				return isMatch(s.substring(1), p.substring(1));
			}
			return false;
		}
	}

	// DP version
	public static boolean isMatch2(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		// first make a 2D array to store data, length is s.length() + 1 because we are
		// considering empty string
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		// if s and p both empty, it is a match
		dp[0][0] = true;

		// dp[i][0] should all be false, because empty pattern cannot match non-empty
		// string, no need to have code for it since boolean array default is false

		// dp[0][j] is true only if dp[0][j-1] is true and p.charAt(j-1) is * (because
		// we added one extra line for empty string)
		// For example, empty string matches #*#*#*#*
		for (int j = 2; j < p.length() + 1; j += 2) {
			// if current char is * and previous state is true
			if (p.charAt(j - 1) == '*' && dp[0][j - 2] == true) {
				dp[0][j] = true;
			}
		}

		// main for loop
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < p.length() + 1; j++) {
				char curs = s.charAt(i - 1);
				char curp = p.charAt(j - 1);
				// If this is a match, then current state equals previous state
				if (curs == curp || curp == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				}
				// If current char at p is *
				else if (curp == '*') {
					char prev = p.charAt(j - 2);
					// if previous is not a match, current state equals previous state, meaning *
					// stands for 0
					if (prev != '.' && prev != curs) {
						dp[i][j] = dp[i][j - 2];
					}
					// if previous is a match, if any of the three situations below is a true, then
					// the current state is also a true
					else {
						dp[i][j] = (dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}

}
