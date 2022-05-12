package easy;

public class RemoveElement_27 {
	public static void main(String[] args) {
	}

	public int removeElement(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}
}
