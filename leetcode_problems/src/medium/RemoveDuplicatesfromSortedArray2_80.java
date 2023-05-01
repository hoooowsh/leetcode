package medium;

public class RemoveDuplicatesfromSortedArray2_80 {
	public static void main(String[] args) {

	}

	public int removeDuplicates(int[] nums) {
		int count = 0;
		int current = nums[0];
		int pointer = 0;
		for (int i = 0; i < nums.length; i++) {
			// if current same as previous
			if (nums[i] == current) {
				count++;
				// if the current should be remember
				if (count <= 2) {
					nums[pointer] = current;
					pointer++;
				}
				// if the current should not be remember
				else {
					continue;
				}
			}
			// if current not same as previous
			else {
				count = 1;
				current = nums[i];
				nums[pointer] = current;
				pointer++;
			}
		}
		return pointer;
	}
}
