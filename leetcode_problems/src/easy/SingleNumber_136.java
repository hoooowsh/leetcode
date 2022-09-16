package easy;

import java.util.HashMap;
import java.util.HashSet;

public class SingleNumber_136 {

	public static void main(String args[]) {

	}

	public static int singleNumber(int[] nums) {
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set1.contains(nums[i])) {
				set1.add(nums[i]);
				set2.add(nums[i]);
			} else {
				if (set2.contains(nums[i])) {
					set2.remove(nums[i]);
				}
			}
		}
		int result = 0;
		for (Integer i : set2) {
			result = i;
		}
		return result;
	}

	// solution using XOR, very smart
	public static int singleNumber2(int[] nums) {
		int a = 0;
		for (int i : nums) {
			a ^= i;
		}
		return a;
	}
}
