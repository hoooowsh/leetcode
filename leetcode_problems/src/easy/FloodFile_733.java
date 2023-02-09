package easy;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFile_733 {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if (image[sr][sc] == color) {
			return image;
		}
		Queue<int[]> stack = new LinkedList<int[]>();
		int origin = image[sr][sc];
		int[] arr = new int[2];
		arr[0] = sr;
		arr[1] = sc;
		stack.add(arr);
		while (!stack.isEmpty()) {
			int[] temparr = stack.poll();
			image[temparr[0]][temparr[1]] = color;
			// up
			if (temparr[0] != 0 && image[temparr[0] - 1][temparr[1]] == origin) {
				int[] temp = new int[2];
				temp[0] = temparr[0] - 1;
				temp[1] = temparr[1];
				stack.add(temp);
			}
			// down
			if (temparr[0] != image.length - 1 && image[temparr[0] + 1][temparr[1]] == origin) {
				int[] temp = new int[2];
				temp[0] = temparr[0] + 1;
				temp[1] = temparr[1];
				stack.add(temp);
			}
			// left
			if (temparr[1] != 0 && image[temparr[0]][temparr[1] - 1] == origin) {
				int[] temp = new int[2];
				temp[0] = temparr[0];
				temp[1] = temparr[1] - 1;
				stack.add(temp);
			}
			// right
			if (temparr[1] != image[0].length - 1 && image[temparr[0]][temparr[1] + 1] == origin) {
				int[] temp = new int[2];
				temp[0] = temparr[0];
				temp[1] = temparr[1] + 1;
				stack.add(temp);
			}
		}
		return image;
	}
}
