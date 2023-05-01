package easy;

public class ValidPerfectSquare_367 {
	public static void main(String[] args) {
		System.out.println(isPerfectSquare(808201));
	}

	public static boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		if (num > 46340 * 46340) {
			return false;
		}
		int l = 1;
		int r = num / 2;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mid >= 46341) {
				mid = 46340;
			}
			int sqrt = mid * mid;
			if (sqrt == num) {
				return true;
			}
			// should go right
			else if (sqrt < num) {
				l = mid + 1;
			}
			// should go left
			else {
				r = mid - 1;
			}
		}
		return false;
	}
}
