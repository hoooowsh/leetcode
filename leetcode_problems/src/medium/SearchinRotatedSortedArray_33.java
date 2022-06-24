package medium;

public class SearchinRotatedSortedArray_33 {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] nums2 = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int[] nums3 = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		int[] nums4 = { 1, 2 };
		int[] nums5 = { 2, 1 };

		int test = search(nums5, 1);
		System.out.println(test);
	}

	// binary search
	public static int search(int[] nums, int target) {
		if (nums.length < 1 || nums == null) {
			return -1;
		}
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}
		int lo = 0;
		int hi = nums.length - 1;
		int mid = lo + (hi - lo) / 2;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			int lovar = nums[lo];
			int hivar = nums[hi];
			int mivar = nums[mid];
			if (mivar == target) {
				return mid;
			}
			// 1: 456789123, hi < lo < mid
			if (hivar < lovar && lovar <= mivar) {
				// 456789123, target = 3, right side
				if (mivar >= target && lovar > target) {
					lo = mid + 1;
					continue;
				}
				// 456789123, target = 4, left side
				else if (mivar >= target && lovar <= target) {
					hi = mid - 1;
					continue;
				}
				// 456789123, target = 9, mivar < target, must be right hand side
				else {
					lo = mid + 1;
					continue;
				}
			}
			// 2: 789123456, mid < hi < lo
			else if (mivar <= hivar && hivar < lovar) {
				// 789123456, must be left
				if (mivar >= target) {
					hi = mid - 1;
					continue;
				}
				// 789123456, must be left
				else if (mivar < target && hivar < target) {
					hi = mid - 1;
					continue;
				}
				// 789123456, must be right
				else {
					lo = mid + 1;
					continue;
				}
			}
			// 4: 56781234
			// 3: 123456789, lo < mid < hi
			else {
				// 123456789, left
				if (mivar >= target) {
					hi = mid - 1;
					continue;
				} else {
					lo = mid + 1;
					continue;
				}
			}
		}
		return -1;
	}
}
