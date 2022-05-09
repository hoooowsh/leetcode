package medium;

public class ContainerwithMostWater_11 {
	public static void main(String[] args) {
		int[] test = { 2, 3, 4, 5, 18, 17, 6 };
		int[] test3 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] test2 = { 1, 1 };
		System.out.println(maxArea(test3));
	}

	// first version, using two pointer. Moving pointer from the smaller side, find
	// the next number that bigger than the smaller integer, make it to the new
	// pointer.
	public static int maxArea(int[] height) {
		int lo = 0;
		int hi = height.length - 1;
		int max = 0;
		if (hi - lo == 1) {
			return Math.min(height[lo], height[hi]);
		}
		while (lo < hi) {
			if (height[lo] < height[hi]) {
				int current = height[lo] * (hi - lo);
				if (current > max) {
					max = current;
				}
				int temp1 = lo;
				for (int i = lo + 1; i <= hi; i++) {
					if (height[i] > height[temp1]) {
						lo = i;
						break;
					}
					lo = i;
				}
			} else {
				int current = height[hi] * (hi - lo);
				if (current > max) {
					max = current;
				}
				int temp2 = hi;
				for (int j = hi - 1; j >= lo; j--) {
					if (height[j] > height[temp2]) {
						hi = j;
						break;
					}
					hi = j;
				}
			}
		}
		return max;
	}
}
