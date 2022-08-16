package medium;

import java.util.ArrayList;

public class MultiplyStrings_43 {
	public static void main(String[] args) {
		String str1 = "401716832807512840963";
		String str2 = "167141802233061013023557397451289113296441069";
		String test = multiply(str1, str2);
		System.out.println(test);
	}

	// simple version simulates multiplication
	public static String multiply(String num1, String num2) {
		boolean isnum1 = false;
		if (num1.length() > num2.length()) {
			isnum1 = true;
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		// if num1 is longer
//		if (isnum1) {
		for (int i = 0; i < num2.length(); i++) {
			// this arr is storing num1 * num2[index]
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int add = 0;
			int temp2 = num2.charAt(num2.length() - i - 1) - '0';
			for (int k = 0; k < i; k++) {
				arr.add(0);
			}
			for (int j = 0; j < num1.length(); j++) {
				int temp1 = num1.charAt(num1.length() - j - 1) - '0';
				int multi = temp1 * temp2 + add;
				if (multi >= 10) {
					String str = Integer.toString(multi);
					add = str.charAt(0) - '0';
					arr.add(str.charAt(1) - '0');
				} else {
					String str = Integer.toString(multi);
					add = 0;
					arr.add(str.charAt(0) - '0');
				}
			}
			if (add != 0) {
				arr.add(add);
			}
			result.add(arr);
		}
		// start add all shit together
		int min = result.get(0).size();
		int max = result.get(result.size() - 1).size();
		String finalresult = "";
		int add2 = 0;
		// this i is largest num length, j is result size

		for (int i = 0; i < max; i++) {
			int temp3 = 0;
			for (int j = 0; j < result.size(); j++) {
				if (i < result.get(j).size()) {
					temp3 += result.get(j).get(i);
				}
			}
			temp3 += add2;
			if (temp3 >= 10) {
				String str = Integer.toString(temp3);
				add2 = Integer.valueOf(str.substring(0, str.length() - 1));
				finalresult = str.charAt(str.length() - 1) + finalresult;
			} else {
				String str = Integer.toString(temp3);
				finalresult = str + finalresult;
				add2 = 0;
			}
		}
		if (add2 != 0) {
			finalresult = add2 + finalresult;
		}
		int ind = 0;
		for (int i = 0; i < finalresult.length(); i++) {
			if (finalresult.charAt(i) == '0') {
				ind++;
			} else {
				break;
			}
		}
		finalresult = finalresult.substring(ind, finalresult.length());
		if (finalresult == "") {
			finalresult = "0";
		}

		return finalresult;
	}
}

//	67143675422804947379429215144664313370120390398055713625298709447
//	67143675422804947379429215144664313370120390398055713625298709447
