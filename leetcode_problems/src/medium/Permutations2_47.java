package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations2_47 {
	public static void main(String[] args) {
		int[] test = { 1, 1, 2, 2, 2 };
		permuteUnique2(test);
	}

	// very slow version, using hash to make sure no duplicates
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		// first loop go over all elements
		List<Integer> permu = new ArrayList<>();
		List<Integer> pos = new ArrayList<>();
		HashSet<String> hash = new HashSet<String>();
		helper(result, permu, nums, pos, "", hash);
		return result;
	}

	public static void helper(List<List<Integer>> result, List<Integer> list, int[] nums, List<Integer> poslist,
			String cur, HashSet<String> hash) {
		if (list.size() == nums.length) {
			if (hash.contains(cur)) {
				return;
			} else {
				hash.add(cur);
				result.add(list);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (!poslist.contains(i)) {
				List<Integer> newlist = new ArrayList<Integer>(list);
				newlist.add(nums[i]);
				String newcur = cur + nums[i];
				List<Integer> newposlist = new ArrayList<Integer>(poslist);
				newposlist.add(i);
				helper(result, newlist, nums, newposlist, newcur, hash);
			}
		}
	}

	// faster version from leetcode discussion
	public static List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		// an array to record element used or not
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, used, list, res);
		return res;
	}

	public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			// if this is not the first element, and it is same as the previous one, and the
			// previous one is not used
			// here !used[i - 1] and used[i - 1] both can be applied, !used[i - 1] is faster
			// reason is because if use !used[i - 1], reduce the backtrack run time
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
				continue;
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, used, list, res);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}

}
