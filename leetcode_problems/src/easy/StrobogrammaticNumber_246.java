package easy;

import java.util.HashMap;

public class StrobogrammaticNumber_246 {
	public static void main(String args[]) {
		System.out.println(isStrobogrammatic("2"));
	}

	public static boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('2', null);
		map.put('3', null);
		map.put('4', null);
		map.put('5', null);
		map.put('6', '9');
		map.put('7', null);
		map.put('8', '8');
		map.put('9', '6');
		for (int i = 0; i < (num.length() + 1) / 2; i++) {
			if (map.get(num.charAt(i)) == null) {
				return false;
			}
			if (map.get(num.charAt(i)) != num.charAt(num.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
