package easy;

public class MaxConsecutiveOnes_485 {
    public static void main(String[] args) {
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                if (current > max) {
                    max = current;
                }
                current = 0;
            } else {
                current++;
            }
        }
        if (current > max) {
            max = current;
        }
        return max;
    }
}
