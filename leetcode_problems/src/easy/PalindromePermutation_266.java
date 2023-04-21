package easy;

public class PalindromePermutation_266 {
	public static void main(String[] args) {

	}

	public static boolean canPermutePalindrome(String s) {
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		boolean repeat = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				if (repeat) {
					return false;
				} else {
					repeat = true;
				}
			}
		}
		return true;
	}
}
