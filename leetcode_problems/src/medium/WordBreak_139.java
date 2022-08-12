package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak_139 {
	public static void main(String[] args) {
		List<String> temp = new ArrayList<String>();
		temp.add("leet");
		temp.add("code");
		boolean boo = wordBreak2("leetcode", temp);
		System.out.println(boo);
	}

	// dp approach, create an array with size s.length + 1, then use nested loop
	// to iterate over the string
	public static boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> wordDictSet = new HashSet<String>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (wordDictSet.contains(s.substring(j, i)) && dp[j]) {
					dp[i] = true;
				}
			}
		}
		return dp[s.length()];
	}

	// BFS approach with memorize, just record a boolean to the letter that being
	// checked by the inside for loop
	public static boolean wordBreak2(String s, List<String> wordDict) {
		HashSet<String> wordDictSet = new HashSet<String>(wordDict);
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[s.length()];
		q.add(0);
		while (!q.isEmpty()) {
			int curIndex = q.poll();
			if (!visited[curIndex]) {
				for (int i = curIndex + 1; i <= s.length(); i++) {
					String str = s.substring(curIndex, i);
					if (wordDictSet.contains(s.substring(curIndex, i))) {
						q.add(i);
						if (i == s.length()) {
							return true;
						}
					}
				}
				visited[curIndex] = true;
			}
		}
		return false;
	}
}
