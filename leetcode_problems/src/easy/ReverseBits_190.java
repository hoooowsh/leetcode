package easy;

public class ReverseBits_190 {
	public static void main(String[] args) {
	}

	public static int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res = (res << 1) | (n & 1);
			n = n >> 1;
		}
		return res;
	}
}
