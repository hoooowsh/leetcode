package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2_90 {
	public static void main(String[] args) {

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(nums);
		result.add(temp);
		helper(nums, result, temp, 0, true);
		return result;
	}

	// first sort it, then loop through
	public static void helper(int[] nums, List<List<Integer>> result, List<Integer> cur, int cur_index,
			Boolean picked) {
		if (cur_index >= nums.length) {
			return;
		}
		int curval = nums[cur_index];

		// not pick cur, skip all
		helper(nums, result, cur, cur_index + 1, false);

		// check if it is picked or not, if not picked and cur is same as prev, return
		if (cur_index > 0 && curval == nums[cur_index - 1] && !picked) {
			return;
		}

		// if it is picked, duplicate no need to worry because its adding one more
		// element to the subset
		cur.add(curval);
		result.add(new ArrayList<>(cur));
		// picked to next
		helper(nums, result, cur, cur_index + 1, true);
		
		cur.remove(cur.size() - 1);
	}
}
