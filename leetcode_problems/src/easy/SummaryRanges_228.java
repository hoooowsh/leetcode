package easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
	public static void main(String args[]) {

	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		int p1 = 0;
		for (int i = 1; i <= nums.length; i++) {
			if (i == nums.length) {
				if (nums[p1] != (nums[i - 1])) {
					String str = nums[p1] + "->" + nums[i - 1];
					result.add(str);
					break;
				} else {
					result.add(String.valueOf(nums[i - 1]));
				}
			} else {
				if (nums[i] - 1 != nums[i - 1]) {
					if (nums[p1] != (nums[i - 1])) {
						String str = nums[p1] + "->" + nums[i - 1];
						result.add(str);
						p1 = i;
					} else {
						p1 = i;
						result.add(String.valueOf(nums[i - 1]));
					}
				} else {
					continue;
				}
			}
		}
		return result;
	}
}
