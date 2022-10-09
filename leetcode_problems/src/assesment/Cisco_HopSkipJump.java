package assesment;

public class Cisco_HopSkipJump {
	public static void funcHopSkipJump(int[][] matrix) {
		// Write your code here
		int height = matrix.length;
		int width = matrix[0].length;
		int currow1 = 0;
		int currow2 = height;
		int curcol1 = 0;
		int curcol2 = width;
		int temp = 0;
		int resultx = 0;
		int resulty = 0;

		int counter = 0;
		while (counter < height * width) {
			// left vertical going down
			for (int i = currow1; i < currow2; i++) {
				temp++;
				if (temp == 2) {
					resultx = i;
					resulty = curcol1;
					temp = 0;
				}
				counter++;
			}

			// bot herizontal going right
			for (int i = curcol1; i < curcol2; i++) {
				if (i == curcol1) {
					continue;
				}
				temp++;
				if (temp == 2) {
					resultx = currow2 - 1;
					resulty = i;
					temp = 0;
				}
				counter++;
			}

			// right vertical going up
			for (int i = currow2 - 1; i >= currow1; i--) {
				if (i == currow2 - 1) {
					continue;
				}
				temp++;
				if (temp == 2) {
					resultx = i;
					resulty = curcol2 - 1;
					temp = 0;
				}
				counter++;
			}

			// top herizontal going left
			for (int i = curcol2 - 1; i > curcol1; i--) {
				if (i == curcol2 - 1) {
					continue;
				}
				temp++;
				if (temp == 2) {
					resultx = currow1;
					resulty = i;
					temp = 0;
				}
				counter++;
			}
			currow1++;
			currow2--;
			curcol1++;
			curcol2--;
		}
		System.out.println(matrix[resultx][resulty]);
	}
}
