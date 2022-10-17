package assesment;

public class Cisco_MaxRowCol {
	public static void main(String args[]) {
		int[][] arr = { { 2, 2 }, { 1, 2 }, { 3, 4 } };
		System.out.println(maxrowcol(arr));

	}

	public static int maxrowcol(int[][] arr) {
		int result = -1;
		// going each row
		for (int i = 0; i < arr.length; i++) {
			// find maximum for current row
			int max = Integer.MIN_VALUE;
			int maxpos = -1;
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
					maxpos = j;
				}
			}
			// for min col, looping through
			boolean boo = true;
			for (int k = 0; k < arr.length; k++) {
				if (arr[k][maxpos] < max) {
					boo = false;
					break;
				}
			}
			if (boo) {
				return max;
			}
		}
		return result;
	}
}
