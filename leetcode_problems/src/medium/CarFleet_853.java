package medium;

import java.util.Arrays;
import java.util.HashMap;

public class CarFleet_853 {
	public static void main(String[] args) {
		int[] test = { 0, 4, 2 };
		int[] test2 = { 2, 1, 3 };
		int result = carFleet(10, test, test2);
	}

	public static int carFleet(int target, int[] position, int[] speed) {
		// first map, pos is key, index is value
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// second map, index is key, speed is value
		for (int i = 0; i < position.length; i++) {
			map.put(position[i], speed[i]);
		}

		// sort the position
		Arrays.sort(position);

		// result
		int counter = 0;
		boolean isFlee = false;
		for (int i = 0; i < position.length - 1; i++) {
			int pos_num_cur = position[i];
			int speed_num_cur = map_speed.get(map_pos.get(pos_num_cur));
			int pos_num_next = position[i + 1];
			int speed_num_next = map_speed.get(map_pos.get(pos_num_next));
			double temp1 = (double) (target - pos_num_cur) / (double) speed_num_cur;
			double temp2 = (double) (target - pos_num_next) / (double) speed_num_next;
			// current call will reach the next car before the target
			if (temp1 <= temp2) {
				isFlee = true;
				continue;
			} else {
				isFlee = false;
				counter++;
			}
		}
		counter++;
		return counter;
	}
}
