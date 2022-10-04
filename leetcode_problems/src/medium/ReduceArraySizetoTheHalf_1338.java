package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ReduceArraySizetoTheHalf_1338 {
	public int minSetSize(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.keySet().contains(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer key : map.keySet()) {
			list.add(map.get(key));
		}
		int count = 0;
		int result = 0;
		Collections.sort(list);
		for (int i = list.size() - 1; i >= 0; i--) {
			count += list.get(i);
			result++;
			if (count >= arr.length / 2) {
				break;
			}
		}
		return result;
	}
}
