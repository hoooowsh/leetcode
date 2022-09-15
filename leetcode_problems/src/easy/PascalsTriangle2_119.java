package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2_119 {
	public static void main(String args[]) {
		getRow(3);
	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < rowIndex + 1; i++) {
			int temp = 0;
			int temp2 = 1;
			for (int j = 0; j < i; j++) {
				// if it has value for previous calculation
				if (j <= i - 1) {
					if (j == 0) {
						result.set(j, 1);
					} else {
						temp = result.get(j);
						int num = result.get(j) + temp2;
						result.set(j, num);
						temp2 = temp;
					}
				}
			}
			result.add(1);
		}
		return result;
	}
}
