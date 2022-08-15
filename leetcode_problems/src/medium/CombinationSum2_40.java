package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_40 {
	public static void main(String[] args) {
		int[] test = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		combinationSum2(test, target);
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		Arrays.sort(candidates);
		helper(candidates, target, result, 0, cur, 0);
		return result;
	}

	public static void helper(int[] candidates, int target, List<List<Integer>> result, int index, List<Integer> cur,
			int curval) {
		for (int i = index; i < candidates.length; i++) {
			if (i > 0) {
				if (i > index && candidates[i] == candidates[i - 1]) {
					continue;
				}
			}
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

	// solution from leetcode
	public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		LinkedList<Integer> comb = new LinkedList<>();

		Arrays.sort(candidates);

		backtrack(candidates, comb, target, 0, results);
		return results;
	}

	private void backtrack(int[] candidates, LinkedList<Integer> comb, Integer remain, Integer curr,
			List<List<Integer>> results) {
		if (remain == 0) {
			// copy the current combination to the final list.
			results.add(new ArrayList<Integer>(comb));
			return;
		}

		for (int nextCurr = curr; nextCurr < candidates.length; ++nextCurr) {
			if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1])
				continue;

			Integer pick = candidates[nextCurr];
			// optimization: early stopping
			if (remain - pick < 0)
				break;

			comb.addLast(pick);
			backtrack(candidates, comb, remain - pick, nextCurr + 1, results);
			comb.removeLast();
		}
	}

}
