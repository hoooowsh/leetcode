package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MeetingRooms2_253 {
	public static void main(String args[]) {
		int[][] test = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int tt = minMeetingRooms(test);
		System.out.println(tt);
	}

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals.length <= 1) {
			return 1;
		}
		Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			arr.add(intervals[i]);
		}
		int counter = 0;
		HashSet<Integer> used = new HashSet<>();
		while (used.size() <= arr.size()) {
			int prev = -1;
			for (int i = 0; i < arr.size(); i++) {
				if (used.contains(i)) {
					continue;
				}
				if (prev == -1) {
					used.add(i);
					prev = arr.get(i)[1];
					continue;
				}
				if (arr.get(i)[0] < prev) {
					continue;
				} else {
					used.add(i);
					prev = arr.get(i)[1];
				}
			}
			counter++;
			prev = -1;
			if (used.size() == arr.size()) {
				break;
			}
		}
		return counter;
	}
}
