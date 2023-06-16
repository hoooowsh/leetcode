package easy;

public class GetMaximuminGeneratedArray_1646 {
	public static void main(String[] args) {
		getMaximumGenerated(3);
	}

	public static int getMaximumGenerated(int n) {
		if (n <= 1) {
			return n;
		}
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		int max = 1;
		for (int i = 2; i < n + 1; i++) {
			if (i % 2 == 0) {
				arr[i] = arr[i / 2];
				if (arr[i] > max) {
					max = arr[i];
				}
			} else {
				arr[i] = arr[(i - 1) / 2] + arr[(i - 1) / 2 + 1];
				if (arr[i] > max) {
					max = arr[i];
				}
			}
		}
		return max;
	}
}
