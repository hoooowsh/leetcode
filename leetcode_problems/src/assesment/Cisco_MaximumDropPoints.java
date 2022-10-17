package assesment;

import java.util.HashMap;

public class Cisco_MaximumDropPoints {
	public static void main(String args[]) {
		int[][] arr = { { 2, 2 }, { 3, 2 }, { 2, 6 }, { 4, 5 }, { 2, 8 } };
		System.out.println(MaxDrop(arr));
	}

	public static int MaxDrop(int[][] arr) {
		HashMap<Integer, Integer> xmap = new HashMap<>();
		HashMap<Integer, Integer> ymap = new HashMap<>();
		int xmax = Integer.MIN_VALUE;
		int ymax = Integer.MIN_VALUE;
		// first checking all x and y in arr
		for (int i = 0; i < arr.length; i++) {
			int xcor = arr[i][0];
			int ycor = arr[i][1];
			// adding x
			if (xmap.containsKey(xcor)) {
				int temp = xmap.get(xcor) + 1;
				xmap.put(xcor, temp);
				if (temp > xmax) {
					xmax = temp;
				}
			} else {
				xmap.put(xcor, 1);
				if (1 > xmax) {
					xmax = 1;
				}
			}
			// adding y
			if (ymap.containsKey(ycor)) {
				int temp = ymap.get(ycor) + 1;
				ymap.put(ycor, temp);
				if (temp > ymax) {
					ymax = temp;
				}
			} else {
				ymap.put(ycor, 1);
				if (1 > ymax) {
					ymax = 1;
				}
			}
		}
		return Math.max(xmax, ymax);
	}
}
