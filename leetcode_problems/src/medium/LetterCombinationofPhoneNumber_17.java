package medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationofPhoneNumber_17 {
	public static void main(String[] args) {
		List<String> l = letterCombinations2("23");
	}

	// second version, DFS, using StringBuilder to have better performance
	final static char[][] L = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public static List<String> letterCombinations2(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits.length() == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helper2(result, 0, digits, sb);
		return result;
	}

	public static void helper2(ArrayList<String> arr, int index, String digits, StringBuilder combo) {
		if (index == digits.length()) {
			arr.add(combo.toString());
			return;
		}
		int dig = Character.getNumericValue(digits.charAt(index));
		for (int i = 0; i < L[dig].length; i++) {
			StringBuilder temp = new StringBuilder(combo);
			temp.append(L[dig][i]);
			helper2(arr, index + 1, digits, temp);
		}
	}

	// first version, brute force
	public List<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(0, "");
		temp.add(1, "");
		temp.add(2, "abc");
		temp.add(3, "edf");
		temp.add(4, "ghi");
		temp.add(5, "jkl");
		temp.add(6, "mno");
		temp.add(7, "pqrs");
		temp.add(8, "tuv");
		temp.add(9, "wxyz");
		if (digits.length() == 0) {
			return result;
		}
		int digitLen = digits.length();
		int firstdigit = digits.charAt(0) - '0';
		for (int i = 0; i < temp.get(firstdigit).length(); i++) {
			String resultstr = temp.get(firstdigit).charAt(i) + "";
			helper(temp, result, 1, digitLen, resultstr, digits);
		}
		return result;
	}

	public void helper(ArrayList<String> container, ArrayList<String> result, int CPos, int len, String resultstr,
			String digits) {
		if (CPos == len) {
			result.add(resultstr);
			return;
		}
		int ndigit = digits.charAt(CPos) - '0';
		String tempstr = "";
		for (int i = 0; i < container.get(ndigit).length(); i++) {
			tempstr = resultstr + container.get(ndigit).charAt(i);
			helper(container, result, CPos + 1, len, tempstr, digits);
		}
	}
}
