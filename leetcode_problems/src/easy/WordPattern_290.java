package easy;

import java.util.HashMap;

public class WordPattern_290 {
	public static void main(String[] args) {
		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(wordPattern(pattern, s));
	}

	public static boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> hash = new HashMap<Character, String>();
		String[] arr = s.split(" ");
		if (pattern.length() != arr.length) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			if (hash.keySet().contains(pattern.charAt(i))) {
				if (!arr[i].equals(hash.get(pattern.charAt(i)))) {
					return false;
				}
			} else {
				if (hash.values().contains(arr[i])) {
					return false;
				}
				hash.put(pattern.charAt(i), arr[i]);
			}
		}
		return true;
	}
}
