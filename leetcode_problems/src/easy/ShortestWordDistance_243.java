package easy;

public class ShortestWordDistance_243 {

	public static void main(String args[]) {

	}

	public static int shortestDistance(String[] wordsDict, String word1, String word2) {
		int cur1 = -1;
		int cur2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < wordsDict.length; i++) {
			if (wordsDict[i].equals(word1)) {
				cur1 = i;
				if (cur2 != -1) {
					int temp = cur1 - cur2;
					if (temp < min) {
						min = temp;
					}
				}
			} else if (wordsDict[i].equals(word2)) {
				cur2 = i;
				if (cur1 != -1) {
					int temp = cur2 - cur1;
					if (temp < min) {
						min = temp;
					}
				}
			} else {
				continue;
			}
		}
		return min;
	}
}
