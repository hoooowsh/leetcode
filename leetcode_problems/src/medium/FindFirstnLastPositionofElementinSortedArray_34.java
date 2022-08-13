package medium;

public class FindFirstnLastPositionofElementinSortedArray_34 {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 2, 3, 3, 4 };
		int[] test = searchRange(arr, 2);

	}

	// first version, use 2 binary search, one for head one for tail
	public static int[] searchRange(int[] nums, int target) {
		if (nums.length < 1 || nums == null) {
			int[] result = { -1, -1 };
			return result;
		}
		int lo = 0;
		int hi = nums.length - 1;
		int mid = lo + (hi - lo) / 2;
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
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
				// here mid is found, going to left to find head
				int l = lo;
				// here mid is target, r is target
				int r = mid;
				int m = 0;
				while (l <= r) {
					m = l + (r - l) / 2;
					if (nums[m] == target) {
						r = m - 1;
						m -= 1;
						if (r < 0) {
							m += 1;
							break;
						}
						if (nums[r] != target) {
							m += 1;
							break;
						}
						continue;
					} else {
						l = m + 1;
						if (l >= nums.length) {
							break;
						}
						continue;
					}
				}
				int leftmost = m;
				l = mid;
				r = hi;
				m = 0;
				// l is always target
				while (l <= r) {
					m = l + (r - l) / 2;
					if (nums[m] == target) {
						l = m + 1;
						m += 1;
						if (l >= nums.length) {
							m -= 1;
							break;
						}
						if (nums[l] != target) {
							m -= 1;
							break;
						}
						continue;
					} else {
						r = m - 1;
						if (r < 0) {
							break;
						}
						continue;
					}
				}
				int rightmost = m;
				result[0] = leftmost;
				result[1] = rightmost;
				break;
			}
		}
		return result;
	}
}
