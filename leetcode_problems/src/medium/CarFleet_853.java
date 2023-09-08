package medium;

import java.util.Arrays;
import java.util.HashMap;

public class CarFleet_853 {
	public static void main(String[] args) {
		int[] test = { 10, 8, 0, 5, 3 };
		int[] test2 = { 2, 4, 1, 1, 3 };
		int result = carFleet(12, test, test2);
		System.out.println(result);
	}

	public static int carFleet(int target, int[] position, int[] speed) {
		// first map has the position as the key, and speed as the value
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < position.length; i++) {
			map.put(position[i], speed[i]);
		}

		// sort the position
		Arrays.sort(position);

		// looping through
		int counter = 1;
		double temptime = 0;
		for (int i = position.length - 1; i > 0; i--) {
			// get current and next pos and speed
			int pos1 = position[i];
			int speed1 = map.get(pos1);
			int pos2 = position[i - 1];
			int speed2 = map.get(pos2);

			// see if the current and next will stuck by calculating the time when they
			// reach the target
			double time1 = 0;
			if (temptime != 0) {
				time1 = temptime;
			} else {
				time1 = ((double) target - (double) pos1) / (double) speed1;
			}
			double time2 = ((double) target - (double) pos2) / (double) speed2;
			// in this, it will stuck before target with a lower speed
			if (time1 > time2) {
				temptime = time1;
			}
			// in this, it will stuck right at target
			else if (time1 == time2) {
				temptime = 0;
			}
			// in this, it will not stuck
			else {
				temptime = 0;
				counter++;
			}

		}
		return counter;
	}

}
