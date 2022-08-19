package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

public class MergeIntervals_56 {
	public static void main(String[] args) {
		int[][] test = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] test2 = { { 1, 4 }, { 5, 6 } };

		int[][] tt = merge(test2);

	}

	// This approach is sorting the start value of the interval
	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		LinkedList<int[]> arrlist = new LinkedList<>();
		// first sort the 2D array
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		arrlist.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];
			if (arrlist.getLast()[1] < start) {
				arrlist.add(intervals[i]);
			} else {
				arrlist.getLast()[1] = Math.max(end, arrlist.getLast()[1]);
			}
		}
		return arrlist.toArray(new int[arrlist.size()][]);
	}
}
