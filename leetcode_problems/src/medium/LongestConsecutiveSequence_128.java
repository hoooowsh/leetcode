package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import easy.ConvertSortedArraytoBST_108.TreeNode;

public class LongestConsecutiveSequence_128 {
	public static void main(String[] args) {
		int[] arr = { 0,3,7,2,5,8,4,6,0,1 };
		System.out.println(longestConsecutive(arr));
	}

	// this version using treeset to auto sort, slow but easy
	public static int longestConsecutive(int[] nums) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			tree.add(nums[i]);
		}
		int counter = 0;
		int max = 0;
		for (Integer i : tree) {
			if (tree.contains(i - 1)) {
				counter++;
			} else {
				counter = 1;
			}
			if(counter > max) {
				max = counter;
			}
		}
		return max;
	}
	
	// this version using array built in sort, fast
    public static int longestConsecutive2(int[] nums) {
       	if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int count = 1;
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i]) {
				continue;
			} else if (nums[i - 1] == nums[i] - 1) {
				count++;
			} else {
				if (count > max) {
					max = count;
				}
				count = 1;
			}
		}
        if (count > max) {
					max = count;
				}
		return max;
    }
}
