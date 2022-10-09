package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearch2_212 {
	public static void main(String args[]) {

	}

	public static List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			set.add(words[i]);
		}
		return result;
	}
}
