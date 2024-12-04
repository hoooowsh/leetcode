package medium;

public class MinimumSizeSubarraySum_209 {

    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = 0;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] < target) {
            return 0;
        }
        int addup = nums[left];
        while (right < nums.length) {
            if (addup >= target) {
                if (result == 0 || right - left + 1 < result) {
                    result = right - left + 1;
                }
                addup -= nums[left];
                left++;
            } else {
                right++;
                if (right >= nums.length) {
                    break;
                }
                addup += nums[right];
            }
        }
        return result;
    }
}