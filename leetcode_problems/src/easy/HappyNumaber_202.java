package easy;

import java.util.HashSet;

public class HappyNumaber_202 {
	public static void main(String[] args) {

	}

	public static boolean isHappy(int n) {
		HashSet<Integer> hash = new HashSet<>();
		while (n != 1 && !hash.contains(n)) {
			hash.add(n);
			n = getnext(n);
		}
		return n == 1;
	}

	public static int getnext(int n) {
		int totalSum = 0;
		while (n > 0) {
			int d = n % 10;
			n = n / 10;
			totalSum += d * d;
		}
		return totalSum;
	}
}
