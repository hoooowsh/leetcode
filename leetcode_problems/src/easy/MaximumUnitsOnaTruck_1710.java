package easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnaTruck_1710 {

	public int maximumUnits(int[][] boxTypes, int truckSize) {
		// sort the array based on second element
		Arrays.sort(boxTypes, Comparator.comparingInt(o -> o[1]));
		int counter = 0;
		int box = 0;
		for (int i = boxTypes.length - 1; i >= 0; i--) {
			if (box + boxTypes[i][0] >= truckSize) {
				counter += (truckSize - box) * boxTypes[i][1];
				break;
			}
			counter += boxTypes[i][0] * boxTypes[i][1];
			box += boxTypes[i][0];
		}
		return counter;
	}
}
