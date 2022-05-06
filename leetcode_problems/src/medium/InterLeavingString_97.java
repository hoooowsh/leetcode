package medium;

import java.util.LinkedList;
import java.util.Queue;

public class InterLeavingString_97 {
	public static void main(String[] args) {
	}

	// BFS version
	public boolean isInterleave1(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		while (queue.size() > 0) {
			
		}
		return false;
	}
}
