package hard;

public class MedianofTwoSortedArr_4 {
	public static void main(String[] args) {
//		findMedianSortedArrays();
	}

	// two pointers, one for nums1, one for nums2. There are total 4 possible
	// situations: p1 went through all elements from nums1, p2 went through all
	// elements from nums2, value in p1 is smaller, value in p2 is smaller.
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0.0;
		boolean divide = false;
		if ((nums1.length + nums2.length) % 2 == 0) {
			divide = true;
		}
		int mid = (nums1.length + nums2.length) / 2 + 1;
		int pos1 = 0;
		int pos2 = 0;
		for (int i = 0; i < mid; i++) {
			if (pos1 >= nums1.length) {
				if (i == mid - 2 && divide) {
					result += nums2[pos2];
					pos2++;
				} else if (i == mid - 1 && divide) {
					result += nums2[pos2];
					pos2++;
				} else if (i == mid - 1 && !divide) {
					return nums2[pos2];
				} else {
					pos2++;
				}
			} else if (pos2 >= nums2.length) {
				if (i == mid - 2 && divide) {
					result += nums1[pos1];
					pos1++;
				} else if (i == mid - 1 && divide) {
					result += nums1[pos1];
					pos1++;
				} else if (i == mid - 1 && !divide) {
					return nums1[pos1];
				} else {
					pos1++;
				}
			} else if (nums1[pos1] < nums2[pos2]) {
				if (i == mid - 2 && divide) {
					result += nums1[pos1];
					pos1++;
				} else if (i == mid - 1 && divide) {
					result += nums1[pos1];
					pos1++;
				} else if (i == mid - 1 && !divide) {
					return nums1[pos1];
				} else {
					pos1++;
				}
			} else {
				if (i == mid - 2 && divide) {
					result += nums2[pos2];
					pos2++;
				} else if (i == mid - 1 && divide) {
					result += nums2[pos2];
					pos2++;
				} else if (i == mid - 1 && !divide) {
					return nums2[pos2];
				} else {
					pos2++;
				}
			}
		}
		if (divide) {
			return result / 2;
		} else {
			return result;
		}
	}
}
