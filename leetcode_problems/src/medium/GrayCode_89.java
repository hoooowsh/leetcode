package medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
	public static void main(String[] args) {
		List<Integer> l = grayCode(2);
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}

	public static List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		int len = n * 2;
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				result.add(0);
			} else if (i <= n) {
				result.add((result.get(i - 1) << 1) + 1);
			} else {
				result.add(result.get(i - 1) >> (i - n) << (i - n));
			}
		}
		return result;
	}
}
