package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestStringChain_1048 {
	public static void main(String args[]) {
		String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
		Arrays.sort(words);
		System.out.println();
	}

	public static int longestStrChain(String[] words) {
		// sort array by string length
		Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
		HashMap<Integer, HashSet<String>> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			// add one length string anyway
			if (words[i].length() == words[0].length()) {
				if (i == 0) {
					HashSet<String> set = new HashSet<>();
					set.add(words[i]);
					map.put(1, set);
					continue;
				} else {
					map.get(1).add(words[i]);
					continue;
				}
			}
			// if the length already exist
			if (map.keySet().contains(words[i].length())) {

			}
			// if the length not exist yet
			else {
				HashSet<String> set = new HashSet<>();
//				set.add(word);
			}
		}
		return 0;
	}
}
