package medium;

public class SearchinRotatedSortedArray2_81 {
	public static void main(String[] args) {
		int[] test = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 };
		System.out.println(search(test, 0));
	}

	public static boolean search(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;
		while (lo <= hi) {
			// first get all values
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[lo] < nums[mid]) {
				if (target >= nums[lo] && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else if (nums[lo] > nums[mid]) {
				if (target > nums[mid] && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			} else {
				lo++;
			}
		}
		return false;
	}
}
