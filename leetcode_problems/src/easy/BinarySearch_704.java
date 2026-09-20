package easy;

public class BinarySearch_704 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (target == nums[index]) {
                result = index;
                break;
            } else if (nums[index] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return result;
    }
}
