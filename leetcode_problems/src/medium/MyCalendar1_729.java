package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyCalendar1_729 {
	public static void main(String args[]) {
		MyCalendar myCalendar = new MyCalendar();
		myCalendar.book(10, 20);
		myCalendar.book(15, 25);
		myCalendar.book(20, 30);
	}

	// use binary search can make this program faster
	public static class MyCalendar {
		LinkedList<int[]> arr;

		public MyCalendar() {
			arr = new LinkedList<int[]>();
		}

		public boolean book(int start, int end) {
			// if the array is empty, it can be booked for sure
			if (arr.size() == 0) {
				int[] temp = new int[2];
				temp[0] = start;
				temp[1] = end;
				arr.add(temp);
				return true;
			}
			// check first index of the array
			if (arr.get(0)[0] >= end) {
				int[] temp = new int[2];
				temp[0] = start;
				temp[1] = end;
				arr.add(0, temp);
				return true;
			}
			// check last index of the array
			if (arr.get(arr.size() - 1)[1] <= start) {
				int[] temp = new int[2];
				temp[0] = start;
				temp[1] = end;
				arr.add(temp);
				return true;
			}
			for (int i = 1; i < arr.size(); i++) {
				if (start >= arr.get(i - 1)[1] && end <= arr.get(i)[0]) {
					int[] temp = new int[2];
					temp[0] = start;
					temp[1] = end;
					arr.add(i, temp);
					return true;
				}
			}
			return false;
		}
	}
}
