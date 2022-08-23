package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
	public static void main(String args[]) {
		int[] test = { 1, 2, 3 };
		List<List<Integer>> tt = subsets(test);

	}

	// backtracking approach
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		result.add(new ArrayList<>());
		if (nums == null || nums.length == 0) {
			return result;
		}
		for (int i = 1; i < nums.length + 1; i++) {
			helper(nums, result, cur, i, 0);
		}
		return result;
	}

	public static void helper(int[] nums, List<List<Integer>> result, List<Integer> cur, int total_size,
			int cur_index) {
		if (cur.size() == total_size) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(cur);
			result.add(temp);
			return;
		}
		for (int i = cur_index; i < nums.length; i++) {
			cur.add(nums[i]);
			helper(nums, result, cur, total_size, i + 1);
			cur.remove(cur.size() - 1);
		}
		return;
	}
}
