package easy;

import java.util.HashSet;

public class ContainsDuplicate_217 {
	public static void main(String[] args) {

	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hash.contains(nums[i])) {
				return true;
			}
			hash.add(nums[i]);
		}
		return false;
	}
}
