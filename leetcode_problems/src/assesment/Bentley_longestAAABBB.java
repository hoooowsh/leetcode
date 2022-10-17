package assesment;

public class Bentley_longestAAABBB {
	public static void main(String args[]) {
		String test = "BAAABAB";
		System.out.println(solution(test));
	}

	public static int solution(String S) {
		if (S == null || S == "") {
			return 0;
		}
		int num_B = 0;
		int counter = 0;
		// going from left to right, count B nums
		// if there is B, increase numB
		// if there is A, see of numB bigger than 0. if numB bigger, then meaning dont
		// need to change the point that we pick A substring, just increase counter and
		// decrease numB. if numB smaller, meaning no B before A, do nothing
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'A') {
				if (num_B > 0) {
					counter++;
					num_B--;
				} else {
//					num_B++;
					continue;
				}
			} else {
				num_B++;
			}
		}
		return counter;
	}

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
