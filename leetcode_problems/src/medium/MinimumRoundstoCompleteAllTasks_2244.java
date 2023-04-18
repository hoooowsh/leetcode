package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumRoundstoCompleteAllTasks_2244 {

	public static void main(String[] args) {
		int[] tasks = { 1, 2, 1 };
		int test = minimumRounds(tasks);
		System.out.println(test);
	}

	public static int minimumRounds(int[] tasks) {
		if (tasks.length == 0 || tasks.length == 1) {
			return -1;
		}
		// sort it first
		Arrays.sort(tasks);
		List<Integer> list = new ArrayList<Integer>();
		// go through the array
		int count = 1;
		int prev = tasks[0];
		for (int i = 1; i < tasks.length; i++) {
			// if this is the last element
			if (i == tasks.length - 1) {
				if (tasks[i] == prev) {
					count++;
					list.add(count);
				} else {
					return -1;
				}
				continue;
			}
			// not the last element
			if (tasks[i] == prev) {
				count++;
				continue;
			} else {
				list.add(count);
				prev = tasks[i];
				count = 1;
			}
		}
		// see if task number makes sense
		int count2 = 0;
		for (int i = 0; i < list.size(); i++) {
			int temp = list.get(i);
			if (temp < 2) {
				return -1;
			} else if (temp == 2 || temp == 3) {
				count2++;
			} else {
				int mod = temp % 3;
				if (mod == 0) {
					count2 += temp / 3;
				} else {
					count2 += temp / 3 + 1;
				}
			}
		}
		return count2;
	}
}
