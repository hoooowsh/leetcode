package assesment;

public class Bentley_CountAlpha {

	// abcdazf for this string, divide it to abcd and azf, for 26 letters, each
	// substring can only contain one of these letters
	public int solution2(String S) {
		// write your code in Java SE 8
		int[] letters = new int[26];
		int counter = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (letters[S.charAt(i) - 'a'] != 0) {
				counter++;
				letters = new int[26];
				letters[S.charAt(i) - 'a']++;
			} else {
				letters[S.charAt(i) - 'a']++;
			}
		}

		return counter + 1;
	}
}
