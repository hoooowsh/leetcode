package easy;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement_169 {
	public static void main(String args[]) {

	}

	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.keySet().contains(nums[i])) {
				int temp = map.get(nums[i]) + 1;
				if (temp > max) {
					max = temp;
					result = nums[i];
				}
				map.put(nums[i], temp);
			} else {
				if (1 > max) {
					max = 1;
					result = nums[i];
				}
				map.put(nums[i], 1);
			}
		}
		return result;
	}

	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
}
