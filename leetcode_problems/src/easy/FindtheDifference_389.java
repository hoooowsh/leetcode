package easy;

public class FindtheDifference_389 {
	public static void main(String[] args) {
		char test = findTheDifference("abcd", "abcde");
		System.out.println(test);
	}

	public static char findTheDifference(String s, String t) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr1[s.charAt(i) - 'a']++;
			arr2[t.charAt(i) - 'a']++;
		}
		arr2[t.charAt(t.length() - 1) - 'a']++;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return (char) (i + 'a');
			}
		}
		return 'a';
	}
}
