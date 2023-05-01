package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionofTwoArrays2_350 {

	public static void main(String[] args) {

	}

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (map1.keySet().contains(nums1[i])) {
				map1.put(nums1[i], map1.get(nums1[i]) + 1);
			} else {
				map1.put(nums1[i], 1);
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (map1.keySet().contains(nums2[i])) {
				arr.add(nums2[i]);
				if (map1.get(nums2[i]) == 1) {
					map1.remove(nums2[i]);
				} else {
					map1.put(nums2[i], map1.get(nums2[i]) - 1);
				}
			}
		}
		int[] result = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			result[i] = arr.get(i);
		}
		return result;
	}
}
