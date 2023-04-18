package easy;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberofOccurrences_1207 {
	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hash.containsKey(arr[i])) {
				hash.put(arr[i], hash.get(arr[i]) + 1);
			} else {
				hash.put(arr[i], 1);
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (Integer i : hash.keySet()) {
			if (set.contains(hash.get(i))) {
				return false;
			}
			set.add(hash.get(i));
		}
		return true;
	}
}
