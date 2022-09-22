package easy;

public class FirstUniqueCharacterinaString_387 {
	public static void main(String args[]) {
		String str = "leetcode";
		System.out.println(firstUniqChar(str));
	}

	public static int firstUniqChar(String s) {
		int[][] letters = new int[26][2];
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 'a';
			letters[num][0]++;
			if (letters[num][1] == 0) {
				letters[num][1] = i;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i][0] == 1 && letters[i][1] < min) {
				min = letters[i][1];
			}
		}
		if (min > s.length()) {
			return -1;
		} else {
			return min;
		}
	}
}
