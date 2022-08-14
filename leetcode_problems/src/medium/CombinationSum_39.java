package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
	public static void main(String[] args) {
		int[] test = { 2, 3, 6, 7 };
		int target = 7;
		combinationSum(test, target);
	}

	// called backtracking approach? First sort then go over all elements
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		Arrays.sort(candidates);
		helper(candidates, target, result, 0, cur, 0);
		return result;
	}

	public static void helper(int[] candidates, int target, List<List<Integer>> result, int index, List<Integer> cur,
			int curval) {
		for (int i = index; i < candidates.length; i++) {
			int total = curval + candidates[i];
			if (total > target) {
				return;
			} else if (total == target) {
				List<Integer> copy = new ArrayList<>(cur);
				copy.add(candidates[i]);
				result.add(copy);
				return;
			} else {
				List<Integer> copy = new ArrayList<>(cur);
				copy.add(candidates[i]);
				helper(candidates, target, result, i, copy, total);
			}
		}
	}
}
