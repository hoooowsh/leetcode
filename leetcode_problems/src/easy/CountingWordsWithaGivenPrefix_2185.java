package easy;

public class CountingWordsWithaGivenPrefix_2185 {

	public static void main(String args[]) {
		String[] str = { "pay", "attention", "practice", "attend" };
		prefixCount(str, "at");
	}

	public static int prefixCount(String[] words, String pref) {
		int counter = 0;
		for (int i = 0; i < words.length; i++) {
			if (pref.length() > words[i].length()) {
				continue;
			}
			String tt = words[i].substring(0, pref.length());
			if (words[i].substring(0, pref.length()).equals(pref)) {
				counter++;
			}
		}
		return counter;
	}
}
