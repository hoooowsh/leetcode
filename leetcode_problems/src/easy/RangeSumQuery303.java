package easy;

public class RangeSumQuery303 {
	static class NumArray {

		public int[] nums;

		public NumArray(int[] nums) {
			this.nums = nums;
		}

		public int sumRange(int left, int right) {
			int result = 0;
			for (int i = left; i <= right; i++) {
				result += this.nums[i];
			}
			return result;
		}
	}
}
