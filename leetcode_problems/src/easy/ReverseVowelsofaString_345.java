package easy;

import java.util.HashSet;

public class ReverseVowelsofaString_345 {
	public static void main(String[] args) {
		String test = reverseVowels("hello");
		System.out.println(test);
	}

	public static String reverseVowels(String s) {
		HashSet<Character> hash = new HashSet<Character>();
		hash.add('a');
		hash.add('A');
		hash.add('e');
		hash.add('E');
		hash.add('i');
		hash.add('I');
		hash.add('o');
		hash.add('O');
		hash.add('u');
		hash.add('U');
		int lo = 0;
		int hi = s.length() - 1;
		boolean b = true;
		while (lo < hi) {
			if (b) {
				if (hash.contains(s.charAt(lo))) {
					b = !b;
				} else {
					lo++;
				}
			} else {
				if (hash.contains(s.charAt(hi))) {
					b = !b;
					char temp = s.charAt(lo);
					char temp2 = s.charAt(hi);
					s = s.substring(0, lo) + temp2 + s.substring(lo + 1, hi) + temp + s.substring(hi + 1, s.length());
					lo++;
					hi--;
				} else {
					hi--;
				}
			}
		}
		return s;
	}
}
