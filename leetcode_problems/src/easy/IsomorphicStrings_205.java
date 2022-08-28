package easy;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings_205 {

	public static void main(String[] args) {

	}

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Character> map = new HashMap<>();
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.keySet().contains(a)) {
				if (map.get(a) != b) {
					return false;
				}
			} else {
				map.put(a, b);
				set.add(b);
				if (set.size() != map.keySet().size()) {
					return false;
				}
			}
		}
		return true;
	}
}
