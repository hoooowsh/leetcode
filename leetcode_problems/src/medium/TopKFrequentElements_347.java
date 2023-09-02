package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TopKFrequentElements_347 {
	public int[] topKFrequent(int[] nums, int k) {
		int[] result = new int[k];
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if (map1.keySet().contains(nums[i])) {
				map1.put(nums[i], map1.get(nums[i]) + 1);
			} else {
				map1.put(nums[i], 1);
			}
		}

		for (int n : map1.keySet()) {
			if (map2.keySet().contains(map1.get(n))) {
				map2.get(map1.get(n)).add(n);
			} else {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(n);
				map2.put(map1.get(n), arr);
			}
		}

		ArrayList<Integer> temp = new ArrayList<Integer>(map2.keySet());
		Collections.sort(temp, Collections.reverseOrder());

		int finalcounter = 0;
		int counterList = 0;
		while (finalcounter < k) {
			int len = map2.get(temp.get(counterList)).size();
			for (int i = 0; i < len; i++) {
				result[i + finalcounter] = map2.get(temp.get(counterList)).get(i);
			}
			finalcounter += len;
			counterList++;

		}
		return result;
	}
}
