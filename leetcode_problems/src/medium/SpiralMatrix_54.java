package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
	public static void main(String[] args) {
		int[][] test = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] test2 = { { 29, 8, 37 }, { 15, 41, 3 }, { 1, 10, 14 } };
		funcHopSkipJump(test2);
		
		List<Integer> tt = spiralOrder(test2);
		for (int i = 0; i < tt.size(); i++) {
			System.out.println(tt.get(i));
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int counter = 0;
		// this is the original size of the matrix
		int height = matrix.length;
		int width = matrix[0].length;
		// this for recording the current position
		int n1 = 0;
		int n2 = 0;
		// this for current square size
		int currow1 = 0;
		int currow2 = height;
		int curcol1 = 0;
		int curcol2 = width;

		while (counter < height * width) {
			// top horizontal
			for (int i = curcol1; i < curcol2; i++) {
				result.add(matrix[currow1][i]);
				counter++;
				if (counter >= height * width) {
					return result;
				}
			}
			// right vertical
			for (int i = currow1; i < currow2; i++) {
				if (i == currow1) {
					continue;
				}
				result.add(matrix[i][curcol2 - 1]);
				counter++;
				if (counter >= height * width) {
					return result;
				}
			}
			// bot horizontal
			for (int i = curcol2 - 1; i >= curcol1; i--) {
				if (i == curcol2 - 1) {
					continue;
				}
				result.add(matrix[currow2 - 1][i]);
				counter++;
				if (counter >= height * width) {
					return result;
				}
			}
			// left vertical
			for (int i = currow2 - 1; i > currow1; i--) {
				if (i == currow2 - 1) {
					continue;
				}
				result.add(matrix[i][curcol1]);
				counter++;
				if (counter >= height * width) {
					return result;
				}
			}
			currow1++;
			currow2--;
			curcol1++;
			curcol2--;
		}
		return result;
	}



}
