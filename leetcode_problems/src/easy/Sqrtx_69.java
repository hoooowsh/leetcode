package easy;

public class Sqrtx_69 {
	public static void main(String[] args) {
		System.out.println(mySqrt(8));
	}

	public static int mySqrt(int x) {
		if (x < 2) {
			return x;
		}
		long num;
		int mid = 0;
		int lo = 2;
		int hi = x / 2;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			num = (long) mid * mid;
			if (num > x) {
				hi = mid - 1;
			} else if (num < x) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return hi;
	}

	public static int mySqit2(int x) {
		int result = (int) Math.sqrt((double)x);
		return result;
	}
}
