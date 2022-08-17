package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
	public static void main(String[] args) {
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> hash = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] char_arr = strs[i].toCharArray();
			Arrays.sort(char_arr);
			String str = String.valueOf(char_arr);
			if (hash.containsKey(str)) {
				hash.get(str).add(strs[i]);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				hash.put(str, list);
			}
		}
		for (String s : hash.keySet()) {
			result.add(hash.get(s));
		}
		return result;
	}
}
