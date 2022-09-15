package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
	public static void main(String args[]) {
		generate(5);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			// set the first and last element to 1
			List<Integer> list = new ArrayList<>();
			list.add(1);

			if (i > 1) {
				for (int j = 1; j < i; j++) {
					list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
				}
			}
			if (i != 0) {
				list.add(1);
			}
			result.add(list);
		}
		return result;
	}
}
