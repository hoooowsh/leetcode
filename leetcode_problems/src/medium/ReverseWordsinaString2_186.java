package medium;

public class ReverseWordsinaString2_186 {
	public static void main(String args[]) {
		char[] test = new char[15];
		test[0] = 't';
		test[1] = 'h';
		test[2] = 'e';
		test[3] = ' ';
		test[4] = 's';
		test[5] = 'k';
		test[6] = 'y';
		test[7] = ' ';
		test[8] = 'i';
		test[9] = 's';
		test[10] = ' ';
		test[11] = 'b';
		test[12] = 'l';
		test[13] = 'u';
		test[14] = 'e';
		reverseWords(test);
	}

	public static void reverseWords(char[] s) {
		if (s.length == 0) {
			return;
		}
		char[] result = new char[s.length];
		int r = s.length - 1;
		int pos = 0;
		for (int i = s.length - 1; i >= 0; i--) {
			if (s[i] == ' ') {
//				int temp = s.length - i - 1;
				insert(result, s, i + 1, r, pos);
				pos += r - i + 1;
				result[pos - 1] = ' ';
				r = i - 1;
			}
			if (i == 0) {
				insert(result, s, i, r, pos);
			}
		}
		for (int i = 0; i < result.length; i++) {
			s[i] = result[i];
		}
	}

	public static void insert(char[] result, char[] s, int l, int r, int pos) {
		for (int i = 0; i < r - l + 1; i++) {
			result[pos + i] = s[l + i];
		}
	}
}
