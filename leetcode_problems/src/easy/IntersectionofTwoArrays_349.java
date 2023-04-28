package easy;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionofTwoArrays_349 {
	public static void main(String[] args) {

	}

	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> hash1 = new HashSet<Integer>();
		HashSet<Integer> hash2 = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			hash1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (hash1.contains(nums2[i])) {
				hash2.add(nums2[i]);
			}
		}
		int[] result = new int[hash2.size()];
		int counter = 0;
		for (Integer temp : hash2) {
			result[counter] = temp;
			counter++;
		}
		return result;
	}
}
