package medium;

import java.util.HashMap;

public class PermutationinString_567 {
	public static void main(String args[]) {
		boolean tt = checkInclusion("hello", "ooolleoooleh");
		System.out.println(tt);
	}

	public static boolean checkInclusion(String s1, String s2) {
		// first go through s1 to get all letters to a hashmap
		HashMap<Character, Integer> hash_s1 = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			if (hash_s1.containsKey(s1.charAt(i))) {
				hash_s1.put(s1.charAt(i), hash_s1.get(s1.charAt(i)) + 1);
			} else {
				hash_s1.put(s1.charAt(i), 1);
			}
		}

		int p1 = 0;
		int p2 = 0;
		HashMap<Character, Integer> hash_s3 = new HashMap<>();
		for (Character c : hash_s1.keySet()) {
			hash_s3.put(c, 0);
		}

		HashMap<Character, Integer> hash_s2 = new HashMap<>(hash_s3);

		int counter = 0;
		while (p2 < s2.length()) {
			char cur = s2.charAt(p2);
			if (!hash_s2.containsKey(cur)) {
				hash_s2 = new HashMap<>(hash_s3);
				p2++;
				p1 = p2;
				counter = 0;
			} else {
				if (hash_s2.get(cur) >= hash_s1.get(cur)) {
					while (p1 <= p2) {
						if (s2.charAt(p1) == cur) {
							p1++;
							p2++;
							break;
						} else {
							hash_s2.put(s2.charAt(p1), hash_s2.get(s2.charAt(p1)) - 1);
							p1++;
							counter--;
						}
					}
				} else {
					hash_s2.put(cur, hash_s2.get(cur) + 1);
					p2++;
					counter++;
					if (counter == s1.length()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
