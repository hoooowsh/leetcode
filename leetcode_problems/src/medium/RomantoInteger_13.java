package medium;

public class RomantoInteger_13 {
	public static void main(String[] args) {
	}

	public int romanToInt(String s) {
		boolean oneBol = false;
		boolean tenBol = false;
		boolean hanBol = false;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I') {
				result += 1;
				oneBol = true;
				tenBol = false;
				hanBol = false;
			} else if (s.charAt(i) == 'V') {
				result += 5;
				if (oneBol) {
					result -= 2;
				}
				oneBol = false;
				tenBol = false;
				hanBol = false;
			} else if (s.charAt(i) == 'X') {
				result += 10;
				if (oneBol) {
					result -= 2;
				}
				oneBol = false;
				tenBol = true;
				hanBol = false;
			} else if (s.charAt(i) == 'L') {
				result += 50;
				if (tenBol) {
					result -= 20;
				}
				oneBol = false;
				tenBol = false;
				hanBol = false;
			} else if (s.charAt(i) == 'C') {
				result += 100;
				if (tenBol) {
					result -= 20;
				}
				oneBol = false;
				tenBol = false;
				hanBol = true;
			} else if (s.charAt(i) == 'D') {
				result += 500;
				if (hanBol) {
					result -= 200;
				}
				oneBol = false;
				tenBol = false;
				hanBol = false;
			} else {
				result += 1000;
				if (hanBol) {
					result -= 200;
				}
				oneBol = false;
				tenBol = false;
				hanBol = false;
			}

		}
		return result;

	}
}
