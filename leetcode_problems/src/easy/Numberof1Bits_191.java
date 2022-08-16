package easy;

public class Numberof1Bits_191 {
	public static void main(String[] args) {
		int test = 00000000000000000000000000001011;
		System.out.println(hammingWeight(test));
	}

	// using bit shifting
	public static int hammingWeight(int n) {
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		return ones;
	}

	// leetcode solution, bit manipulation
	public static int hammingWeight2(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			// n: 110100
			// n - 1: 110011
			// n & n-1 : 110000
			// cancel out the least significant 1 in n
			n &= (n - 1);
		}
		return sum;
	}
}
