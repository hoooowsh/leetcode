package easy;

public class CountingBits_338 {
	public static void main(String[] args) {
		int test[] = countBits(5);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}

	public static int[] countBits(int n) {
		int[] result = new int[n + 1];
		int powoftwo_cur = 0;
		int powoftwocount = 0;
		int powoftwo = 0;
		for (int i = 0; i < result.length; i++) {
			if (i == 0) {
				result[i] = 0;
				continue;
			}
			if (i == 1) {
				result[i] = 1;
				powoftwo = 2;
				powoftwocount = 1;
				powoftwo_cur = 2;
				continue;
			}
			if (powoftwo_cur > 1) {
				if (powoftwo_cur > powoftwo / 2) {
					result[i] = result[i - powoftwo / 2];
				} else {
					result[i] = result[i - powoftwo / 2] + 1;
				}
				powoftwo_cur--;

			} else {
				result[i] = result[i - powoftwo / 2] + 1;
				powoftwocount++;
				powoftwo = (int) Math.pow(2, powoftwocount);
				powoftwo_cur = powoftwo;
			}
		}
		return result;
	}
}
