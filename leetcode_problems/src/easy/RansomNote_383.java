package easy;

import java.util.HashMap;

public class RansomNote_383 {
	public static void main(String[] args) {

	}

	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < magazine.length(); i++) {
			if (map.keySet().contains(magazine.charAt(i))) {
				map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
			} else {
				map.put(magazine.charAt(i), 1);
			}
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (map.keySet().contains(ransomNote.charAt(i))) {
				if (map.get(ransomNote.charAt(i)) == 1) {
					map.remove(ransomNote.charAt(i));
				} else {
					map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
