package easy;

import java.util.LinkedList;
import java.util.List;

public class MissingRanges_163 {
	public static void main(String args[]) {
		int[] nums = { 0, 9 };
		int lower = 0;
		int upper = 9;
		List<List<Integer>> test = findMissingRanges(nums, lower, upper);
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
	}

	// this solution is go through all the possibilities and get the ranges
	public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		// if the array is empty
		if (nums.length == 0) {
			List<Integer> l1 = new LinkedList<Integer>();
			l1.add(lower);
			l1.add(upper);
			result.add(l1);
			return result;
		}
		// if the array only has one element
		if (nums.length == 1) {
			// if its in range
			if (nums[0] < upper && nums[0] > lower) {
				List<Integer> l1 = new LinkedList<Integer>();
				l1.add(lower);
				l1.add(nums[0] - 1);
				List<Integer> l2 = new LinkedList<Integer>();
				l2.add(nums[0] + 1);
				l2.add(upper);
				result.add(l1);
				result.add(l2);
			} else if (nums[0] == lower && nums[0] + 1 <= upper) {
				List<Integer> l1 = new LinkedList<Integer>();
				l1.add(nums[0] + 1);
				l1.add(upper);
				result.add(l1);
			} else if (nums[0] == upper && nums[0] - 1 >= lower) {
				List<Integer> l1 = new LinkedList<Integer>();
				l1.add(lower);
				l1.add(upper - 1);
				result.add(l1);
			}
			// if its not in range
			else {

			}
			return result;
		}
		// if the array has more than one elements
		for (int i = 0; i < nums.length - 1; i++) {
			// if this is the first element
			if (i == 0) {
				// if the current element is in the range
				if (nums[i] < upper && nums[i] > lower) {
					List<Integer> l1 = new LinkedList<Integer>();
					l1.add(lower);
					l1.add(nums[i] - 1);
					result.add(l1);
					// if the next element is current element + 1, meaning they are connected
					if (nums[i] + 1 == nums[i + 1]) {
						continue;
					} else {
						List<Integer> l2 = new LinkedList<Integer>();
						l2.add(nums[i] + 1);
						l2.add(nums[i + 1] - 1);
						result.add(l2);
						continue;
					}
				}
				// if the first element is the lower bond, continue
				else if (nums[i] == lower) {
					if (nums[i] + 1 == nums[i + 1]) {
						continue;
					} else {
						List<Integer> l1 = new LinkedList<Integer>();
						l1.add(nums[i] + 1);
						l1.add(nums[i + 1] - 1);
						result.add(l1);
						continue;
					}
				}
				// if the first element is the upper bond
				else if (nums[i] == upper && nums[i] - 1 >= lower) {
					List<Integer> l1 = new LinkedList<Integer>();
					l1.add(lower);
					l1.add(nums[i] - 1);
					result.add(l1);
					break;
				}
				// if the element is not in the range
				else {
					break;
				}
			}
			// if this the element in between
			else {
				// if in range
				if (nums[i] < upper && nums[i] > lower) {
					if (nums[i] + 1 == nums[i + 1]) {
						continue;
					} else {
						List<Integer> l1 = new LinkedList<Integer>();
						l1.add(nums[i] + 1);
						l1.add(nums[i + 1] - 1);
						result.add(l1);
						continue;
					}
				}
				// if the first element is the upper bond
				else if (nums[i] == upper && nums[i] - 1 >= lower) {
					List<Integer> l1 = new LinkedList<Integer>();
					l1.add(lower);
					l1.add(nums[i] - 1);
					result.add(l1);
					break;
				}
				// if the element is not in the range
				else {
					break;
				}
			}
		}
		// the last element is in the range
		int last = nums.length - 1;
		if (nums[last] != upper) {
			List<Integer> l1 = new LinkedList<Integer>();
			l1.add(nums[last] + 1);
			l1.add(upper);
			result.add(l1);
		}
		return result;
	}

	// this solution is easier but cost more time
	public static List<String> findMissingRanges2(int[] nums, int lower, int upper) {
		List<String> result = new LinkedList<String>();
		return result;
	}
}
