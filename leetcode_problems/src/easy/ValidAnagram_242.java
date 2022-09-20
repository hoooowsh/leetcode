package easy;

import java.util.Arrays;

public class ValidAnagram_242 {

	public static void main(String args[]) {

	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] s1 = s.toCharArray();
		Arrays.sort(s1);
		char[] t1 = t.toCharArray();
		Arrays.sort(t1);
		for (int i = 0; i < s.length(); i++) {
			if (s1[i] != t1[i]) {
				return false;
			}
		}
		return true;
	}

	// faster version using 26 size array
	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] arr = new int[26];
		int[] arr2 = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			arr2[t.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
}
