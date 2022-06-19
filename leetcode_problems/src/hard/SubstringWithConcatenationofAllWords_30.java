package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstringWithConcatenationofAllWords_30 {
	public static void main(String[] args) {
		String s = "wordgoodgoodgoodbestword";
		String[] words = { "word", "good", "best", "good" };
		List<Integer> result = findSubstring(s, words);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	// using hash map version
	public static List<Integer> findSubstring(String s, String[] words) {
		// note all words in words array is SAME length
		List<Integer> result = new ArrayList<Integer>();
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		int size = 0;
		int wordlen = words[0].length();
		for (int i = 0; i < words.length; i++) {
			if (hash.keySet().contains(words[i])) {
				int count = hash.get(words[i]);
				hash.replace(words[i], count + 1);
				size += words[i].length();
			} else {
				hash.put(words[i], 1);
				size += words[i].length();
			}
		}
		// looping through string s
		for (int i = 0; i < s.length() - size + 1; i++) {
			String substr = s.substring(i, i + size);
			HashMap<String, Integer> temphash = new HashMap<String, Integer>(hash);
			boolean found = true;
			for (int j = 0; j < substr.length(); j += wordlen) {
				if (temphash.keySet().contains(substr.substring(j, j + wordlen))) {
					if (temphash.get(substr.substring(j, j + wordlen)) == 1) {
						temphash.remove(substr.substring(j, j + wordlen));
					} else {
						int count = temphash.get(substr.substring(j, j + wordlen));
						temphash.replace(substr.substring(j, j + wordlen), count - 1);
					}
				} else {
					found = false;
					break;
				}
			}
			if (found) {
				result.add(i);
			}
		}
		// abcdefg
		// abcd abc defghijklmn
		return result;
	}
}
