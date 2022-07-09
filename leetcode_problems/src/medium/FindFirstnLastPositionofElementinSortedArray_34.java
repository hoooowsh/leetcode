package medium;

public class FindFirstnLastPositionofElementinSortedArray_34 {

	public static void main(String[] args) {
	}

	// first version, use 2 binary search, one for head one for tail
	public int[] searchRange(int[] nums, int target) {
		if (nums.length < 1 || nums == null) {
			int[] result = { -1, -1 };
			return result;
		}
		int lo = 0;
		int hi = nums.length - 1;
		int mid = lo + (hi - lo) / 2;

		// first loop searching for head
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			int lovar = nums[lo];
			int hivar = nums[hi];
			int mivar = nums[mid];
			// if mid < target, right side
			if (mivar < target) {
				lo = mid + 1;
				continue;
			}
			// if mid > target, left side
			else if (mivar > target) {
				hi = mid - 1;
				continue;
			}
			// if mid == target, left side, but current mid might be head
			else {
				if (mid - 1 != -1) {
					if (nums[mid - 1] != target) {
						
					}
				}
			}

		}

		return nums;
	}
}
