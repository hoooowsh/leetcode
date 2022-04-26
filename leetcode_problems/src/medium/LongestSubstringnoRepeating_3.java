package medium;

import java.util.HashSet;

public class LongestSubstringnoRepeating_3 {
	public static void main(String[] args) {
		lengthOfLongestSubstring3("abcabcbb");
	}

	// dummy version
	public static int lengthOfLongestSubstring(String s) {
		HashSet<Character> hash = new HashSet<Character>();
		int max = 0;
		// this loop is for the first char position
		for (int i = 0; i < s.length(); i++) {
			int current = 0;
			for (int j = i; j < s.length(); j++) {
				if (hash.contains(s.charAt(j))) {
					break;
				} else {
					hash.add(s.charAt(j));
					current++;
				}
			}
			if (current > max) {
				max = current;
			}
			hash.clear();
		}
		return max;
	}

	// has two pointers, if there is repeating, move head pointer until there is no
	// repeating. If there is no repeating, move tail pointer
	public static int lengthOfLongestSubstring2(String s) {
		int head = 0;
		int tail = 0;
		int max = 0;
		HashSet<Character> hash = new HashSet<Character>();
		while (tail < s.length()) {
			if (!hash.contains(s.charAt(tail))) {
				hash.add(s.charAt(tail));
				if (hash.size() > max) {
					max = hash.size();
				}
				tail++;
			} else {
				hash.remove(s.charAt(head));
				head++;
			}
		}
		return max;
	}

	// logic like version 2, but using ASCII table to store chars
	public static int lengthOfLongestSubstring3(String s) {
		// total char number is 256
		int[] asc = new int[256];
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			asc[temp]++;
			if (asc[temp] <=1) {
				max = Math.max(max, i - j + 1);
			}
			// if the value is bigger than 1, then there must have a repeat
			while (asc[temp] > 1) {
				char temp2 = s.charAt(j);
				asc[temp2]--;
				j++;
			}
		}
		return max;
	}
}
