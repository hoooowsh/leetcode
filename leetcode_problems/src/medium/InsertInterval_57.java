package medium;

import java.util.LinkedList;

public class InsertInterval_57 {
	public static void main(String[] args) {
		int[][] test = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] test2 = { 4, 8 };
		int[][] tt = insert(test, test2);
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		LinkedList<int[]> list = new LinkedList<>();
		int start = newInterval[0];
		int end = newInterval[1];
		int temps = -1;
		int tempe = -1;
		boolean catchstart = false;
		boolean startin = false;
		boolean endin = false;
		boolean catchend = false;

		for (int i = 0; i < intervals.length; i++) {
			// if start and end catch already, add this range to list
			if (catchstart && catchend) {
				list.add(intervals[i]);
			}
			// if start and end both not catch, check if can catch start
			if (!catchstart && !catchend) {
				// catch start before current interval
				if (before(intervals, i, start)) {
					catchstart = true;
					temps = start;
				}
				// catch start in between of current interval
				else if (inbetween(intervals, i, start)) {
					catchstart = true;
					temps = intervals[i][0];
				}
				// not catch start
				else {
					list.add(intervals[i]);
					continue;
				}
			}
			// if start catch, but end not catch
			if (catchstart && !catchend) {
				// catch end before current interval
				if (before(intervals, i, end)) {
					catchend = true;
					tempe = end;
					int[] arr = new int[2];
					arr[0] = temps;
					arr[1] = tempe;
					list.add(arr);
					list.add(intervals[i]);
					continue;
				}
				// catch end in between
				else if (inbetween(intervals, i, end)) {
					catchend = true;
					tempe = intervals[i][1];
					int[] arr = new int[2];
					arr[0] = temps;
					arr[1] = tempe;
					list.add(arr);
					continue;
				}
				// not catch end
				else {
					continue;
				}
			}
		}
		if (temps == -1 && tempe == -1) {
			list.add(newInterval);
			return list.toArray(new int[list.size()][]);
		}
		if (tempe == -1) {
			int[] arr = new int[2];
			arr[0] = temps;
			arr[1] = end;
			list.add(arr);
		}
		return list.toArray(new int[list.size()][]);
	}

	public static boolean inbetween(int[][] intervals, int index, int num) {
		int start = intervals[index][0];
		int end = intervals[index][1];
		if (start > num || end < num) {
			return false;
		}
		return true;
	}

	public static boolean before(int[][] intervals, int index, int num) {
		if (intervals[index][0] > num) {
			return true;
		}
		return false;
	}

	public static boolean after(int[][] intervals, int index, int num) {
		if (intervals[index][1] < num) {
			return true;
		}
		return false;
	}
}
