package easy;

public class ValidPalindrome_125 {
	public static void main(String args[]) {
		String s = "A man, a plan, a canal: Panama";
		String s2 = ".,";
		String s3 = "0p";
		boolean tt = isPalindrome(s2);
		System.out.println(tt);
	}

	public static boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}

			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
		}

		return true;
	}
}
