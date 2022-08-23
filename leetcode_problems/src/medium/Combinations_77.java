package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {
	public static void main(String args[]) {
		List<List<Integer>> test = combine(4, 2);

	}

	// backtracking approach
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		// k is the size of the subset
		helper(result, cur, 0, 0, k, n);
		return result;
	}

	public static void helper(List<List<Integer>> result, List<Integer> cur, int num, int cursize, int k, int n) {
		if (cursize == k) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(cur);
			result.add(temp);
			return;
		}
		for (int i = num; i < n; i++) {
			if (num + 1 <= n) {
				cur.add(i + 1);
				helper(result, cur, i + 1, cursize + 1, k, n);
				cur.remove(cursize);
			} else {
				return;
			}
		}
	}
}
