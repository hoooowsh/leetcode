package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
	public static void main(String[] args) {
	}

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		helper(result, n, "", 0, 0);
		return result;
	}

	// Using backtracking. Basically, if left number is smaller than n, then it is
	// safe to add at least one more left. If right number is smaller than left
	// number, then it is safe to add at least one more right. Using recursion to
	// solve
	public static void helper(List<String> result, int maxlen, String current, int leftnum, int rightnum) {
		if (current.length() == maxlen * 2) {
			result.add(current);
			return;
		}
		if (leftnum < maxlen) {
			helper(result, maxlen, current + "(", leftnum + 1, rightnum);
		}
		if (rightnum < leftnum) {
			helper(result, maxlen, current + ")", leftnum, rightnum + 1);
		}
	}
}
