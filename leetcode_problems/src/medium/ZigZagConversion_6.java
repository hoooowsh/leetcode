package medium;

import java.util.ArrayList;

public class ZigZagConversion_6 {
	public static void main(String[] args) {
		String test = "PAYPALISHIRING";
		String str = convert(test, 4);
		System.out.println(str);
	}

	// Using math stuff. StringBuilder can be faster.
	public static String convert(String s, int numRows) {
		ArrayList<ArrayList<Character>> arr = new ArrayList<ArrayList<Character>>();
		for (int i = 0; i < numRows; i++) {
			arr.add(new ArrayList<Character>());
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (count >= numRows + numRows - 2) {
				count = 0;
			}
			if (count < numRows) {
				arr.get(count).add(s.charAt(i));
			} else {
				arr.get(numRows - 1 - (count - numRows + 1)).add(s.charAt(i));
			}
			count++;
		}

		String result = "";
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {
				result += arr.get(i).get(j);
			}
		}
		return result;
	}
}
