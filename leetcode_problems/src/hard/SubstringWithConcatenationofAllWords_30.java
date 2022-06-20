package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationofAllWords_30 {
	public static void main(String[] args) {
		String s = "wordgoodgoodgoodbestword";
		String[] words = { "word", "good", "best", "good" };
		List<Integer> result = findSubstring2(s, words);
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
		return result;
	}

	///////////////////////////////////////////////////////////////////////
	/// A really fast solution copied from online, using sliding window ///
	///////////////////////////////////////////////////////////////////////

	// Basically, the first loop going from 0 to words length, because for example,
	// barfoothefoobarman with words = ["foo","bar"], we can check substring
	// starting from (0, 3), (3, 6), (6, 9)... and (1, 4), (4, 7), (7, 10)... and
	// (2, 5), (5, 8), (8, 11)... applying sliding window to the remaining loops, it
	// will be fast

	static private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
	// length of string s
	static private int n;
	// length of each word
	static private int wordLength;
	// length of all words
	static private int substringSize;
	// length of words array
	static private int k;

	public static List<Integer> findSubstring2(String s, String[] words) {
		n = s.length();
		k = words.length;
		wordLength = words[0].length();
		substringSize = wordLength * k;
		// record all words in a hashmap
		for (String word : words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}
		List<Integer> answer = new ArrayList<>();
		// looping through using word length???
		for (int i = 0; i < wordLength; i++) {
			slidingWindow(i, s, answer);
		}
		return answer;
	}

	private static void slidingWindow(int left, String s, List<Integer> answer) {
		HashMap<String, Integer> wordsFound = new HashMap<>();
		int wordsUsed = 0;
		boolean excessWord = false;

		// Do the same iteration pattern as the previous approach - iterate
		// word_length at a time, and at each iteration we focus on one word
		for (int right = left; right <= n - wordLength; right += wordLength) {

			String sub = s.substring(right, right + wordLength);
			if (!wordCount.containsKey(sub)) {
				// Mismatched word - reset the window
				wordsFound.clear();
				wordsUsed = 0;
				excessWord = false;
				left = right + wordLength;
			} else {
				// If we reached max window size or have an excess word
				while (right - left == substringSize || excessWord) {
					String leftmostWord = s.substring(left, left + wordLength);
					left += wordLength;
					wordsFound.put(leftmostWord, wordsFound.get(leftmostWord) - 1);

					if (wordsFound.get(leftmostWord) >= wordCount.get(leftmostWord)) {
						// This word was an excess word
						excessWord = false;
					} else {
						// Otherwise we actually needed it
						wordsUsed--;
					}
				}

				// Keep track of how many times this word occurs in the window
				wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
				if (wordsFound.get(sub) <= wordCount.get(sub)) {
					wordsUsed++;
				} else {
					// Found too many instances already
					excessWord = true;
				}

				if (wordsUsed == k && !excessWord) {
					// Found a valid substring
					answer.add(left);
				}
			}
		}
	}

}
