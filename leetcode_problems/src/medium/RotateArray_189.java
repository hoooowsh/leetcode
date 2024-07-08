package medium;

public class RotateArray_189 {
    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4, 5, 6 };
        rotate(test, 4);
    }

    // Approach 1, first reverse the whole array, then reverse the first half, and
    // then reverse the second half
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % nums.length;
        // Reverse the whole array
        Reverse(nums, 0, len - 1);
        // Reverse the first half
        Reverse(nums, 0, k - 1);
        // Reverse the second half
        Reverse(nums, k, len - 1);
    }

    // Helper function for approach 1, using two pointers to do the reverse
    public static void Reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
