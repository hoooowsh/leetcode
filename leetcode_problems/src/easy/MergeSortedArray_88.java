package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortedArray_88 {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 3, 0, 0, 0 };
		int[] t2 = { 2, 5, 6 };
		merge(t1, 3, t2, 3);
		int[] t3 = { 0 };
		int[] t4 = { 1 };
		merge2(t3, 0, t4, 1);
	}

	// first version tracking from head to tail
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		int curpos = 0;
		int pointer2 = 0;
		while (curpos < nums1.length) {
			// add elements in nums1 to queue always
			if (curpos < m) {
				q.add(nums1[curpos]);
			}
			// if q is empty, meaning elements all left in nums2
			if (q.isEmpty()) {
				nums1[curpos] = nums2[pointer2];
				pointer2++;
			} else if (pointer2 >= n) {
				nums1[curpos] = q.poll();
			}
			// if q is not empty, make a comparison
			else {
				if (q.peek() > nums2[pointer2]) {
					nums1[curpos] = nums2[pointer2];
					pointer2++;
				} else {
					nums1[curpos] = q.poll();
				}
			}
			curpos++;
		}
	}

	// second version tracking from tail to head
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int pointer = nums1.length - 1;
		while (pointer >= 0) {
			if (m <= 0) {
				nums1[pointer] = nums2[n - 1];
				n--;
			} else if (n <= 0) {
				nums1[pointer] = nums1[m - 1];
				m--;
			} else {
				if (nums1[m - 1] > nums2[n - 1]) {
					nums1[pointer] = nums1[m - 1];
					m--;
				} else {
					nums1[pointer] = nums2[n - 1];
					n--;
				}
			}
			pointer--;
		}
	}
}
