package assesment;

import java.util.Arrays;

public class Cisco_TwinSurvey {
	public static void main(String args[]) {
		int[] arr = { 1, 1, 2, 3, 3, 4, 4 };
		System.out.println(FindTwin(arr));
	}

	public static int FindTwin(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		Arrays.sort(arr);
		if (arr[0] != arr[1]) {
			return arr[0];
		}
		for (int i = 1; i < arr.length - 1; i++) {
			// find the not twin one
			if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
				return arr[i];
			}
		}
		if (arr[arr.length - 1] != arr[arr.length - 2]) {
			return arr[arr.length - 1];
		}
		return -1;
	}
}
