package easy;

import java.util.Arrays;

public class MeetingRooms_252 {
	public static void main(String args[]) {
	}

	public boolean canAttendMeetings(int[][] intervals) {
		if (intervals.length <= 1) {
			return true;
		}
		Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[i - 1][1]) {
				return false;
			}
		}
		return true;
	}
}
