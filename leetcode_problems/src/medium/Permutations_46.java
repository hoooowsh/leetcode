package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
	public static void main(String[] args) {
		int[] test = { 1, 2, 3 };
		permute(test);
	}

	// my own backtracking approach,
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		// first loop go over all elements
		List<Integer> permu = new ArrayList<>();
		helper(result, permu, nums);
		return result;
	}

	public static void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(list);
		}
		for (int i = 0; i < nums.length; i++) {
			if (!list.contains(nums[i])) {
				List<Integer> newlist = new ArrayList<Integer>(list);
				newlist.add(nums[i]);
				helper(result, newlist, nums);
			}
		}
	}

	// leetcode fast version, also using backtracking, but using swapping for better
	// performance
	////////////////////////////////////////////////////////////////////////////
	// here is the logic
	////////////////////////////////////////////////////////////////////////////
	/*
	 * 1. If the first integer to consider has index n that means that the current
	 * permutation is done.
	 * 2. Iterate over the integers from index first to index n -1. 
	 *    	(1) Place i-th integer first in the permutation, i.e. swap(nums[first],
	 * nums[i]). 
	 * 		(2) Proceed to create all permutations which starts from i-th integer :
	 * backtrack(first + 1). 
	 * 		(3) Now backtrack, i.e. swap(nums[first], nums[i]) back.
	 */
	public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
		// if all integers are used up
		if (first == n)
			output.add(new ArrayList<Integer>(nums));
		for (int i = first; i < n; i++) {
			// place i-th integer first
			// in the current permutation
			Collections.swap(nums, first, i);
			// use next integers to complete the permutations
			backtrack(n, nums, output, first + 1);
			// backtrack
			Collections.swap(nums, first, i);
		}
	}

	public List<List<Integer>> permute2(int[] nums) {
		// init output list
		List<List<Integer>> output = new LinkedList();
		// convert nums into list since the output is a list of lists
		ArrayList<Integer> nums_lst = new ArrayList<Integer>();
		for (int num : nums)
			nums_lst.add(num);

		int n = nums.length;
		backtrack(n, nums_lst, output, 0);
		return output;
	}
}
