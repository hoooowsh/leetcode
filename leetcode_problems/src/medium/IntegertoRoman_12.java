package medium;

public class IntegertoRoman_12 {
	public static void main(String[] args) {
	}

	public static String intToRoman(int num) {
		String result = "";
		while (num > 0) {
			if (num >= 1000) {
				num -= 1000;
				result += "M";
			} else if (num >= 900) {
				num -= 900;
				result += "CM";
			} else if (num >= 500) {
				num -= 500;
				result += "D";
			} else if (num >= 400) {
				num -= 400;
				result += "CD";
			} else if (num >= 100) {
				num -= 100;
				result += "C";
			} else if (num >= 90) {
				num -= 90;
				result += "XC";
			} else if (num >= 50) {
				num -= 50;
				result += "L";
			} else if (num >= 40) {
				num -= 40;
				result += "XL";
			} else if (num >= 10) {
				num -= 10;
				result += "X";
			} else if (num >= 9) {
				num -= 9;
				result += "IX";
			} else if (num >= 5) {
				num -= 5;
				result += "V";
			} else if (num >= 4) {
				num -= 4;
				result += "IV";
			} else {
				num -= 1;
				result += "I";
			}
		}
		return result;
	}

	private static final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static final String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public String intToRoman2(int num) {
		StringBuilder sb = new StringBuilder();
		// Loop through each symbol, stopping if num becomes 0.
		for (int i = 0; i < values.length && num > 0; i++) {
			// Repeat while the current symbol still fits into num.
			while (values[i] <= num) {
				num -= values[i];
				sb.append(symbols[i]);
			}
		}
		return sb.toString();
	}
}
