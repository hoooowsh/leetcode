package medium;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits_1291 {
	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> result = new ArrayList<Integer>();
		String str = "123456789";
		int lowlen = Integer.toString(low).length();
		int highlen = Integer.toString(high).length();
		for (int i = lowlen; i <= highlen; i++) {
			int temp = 0;
			while (temp + i <= 9) {
				if (Integer.parseInt(str.substring(temp, temp + i)) >= low
						&& Integer.parseInt(str.substring(temp, temp + i)) <= high) {
					result.add(Integer.parseInt(str.substring(temp, temp + i)));
				}
				temp++;
			}
		}

		return result;
	}
}
