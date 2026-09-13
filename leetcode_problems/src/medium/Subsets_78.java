package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
	public static void main(String args[]) {
		int[] test = { 1, 2, 3 };
		List<List<Integer>> tt = subsets(test);

	}

	// The number of subset will be (2 ^ nums.length) -> because for each element of
	// the array, we have options to inlucde it or not include it, which is 2, and n
	// of them, which is 2 ^ n
	// If we count all of them, like we have 2^n subsets, and each of them could
	// have up to n elements, the worst case complexity will be O(n*2^n)
	// Using backtracking, draw dicision tree, for each level l, we can choose to
	// add the l idnex of the array, or not
	public static List<List<Integer>> subsets3(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			helper(result, nums[i]);
		}
		return result;
	}

	public static void helper(List<List<Integer>> result, int cur) {
		int size = result.size();
		for (int i = 0; i < size; i++) {
			List<Integer> temp = new ArrayList<>(result.get(i));
			temp.add(cur);
			result.add(temp);
		}
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
