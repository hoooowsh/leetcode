package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ContainsDuplicate2_219 {

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 1, 1, 2, 3 };
		boolean tt = containsNearbyDuplicate(test, 0);
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k == 0) {
			return false;
		}
		HashSet<Integer> q = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (q.contains(nums[i])) {
				return true;
			}
			if (q.size() >= k) {
				q.remove(nums[i - k]);
			}
			q.add(nums[i]);
		}
		return false;
	}
}
