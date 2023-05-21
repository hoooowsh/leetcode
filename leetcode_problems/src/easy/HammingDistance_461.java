package easy;

public class HammingDistance_461 {
	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

	public static int hammingDistance(int x, int y) {
		int counter = 0;
		while (x != 0 || y != 0) {
			if (x % 2 == 0 && y % 2 == 0 || x % 2 == 1 && y % 2 == 1) {
				x = x >> 1;
				y = y >> 1;
				continue;
			} else {
				counter++;
				x = x >> 1;
				y = y >> 1;
				continue;
			}
		}
		return counter;
	}
}
