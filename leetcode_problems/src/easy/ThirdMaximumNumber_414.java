package easy;

import java.util.ArrayList;
import java.util.HashSet;

public class ThirdMaximumNumber_414 {
    public static void main(String[] args) {
        int[] test = { 1, 2, 2, 5, 3, 5 };
        int result = thirdMax(test);
    }

    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (set.contains(temp)) {
                continue;
            }
            if (set.size() < 3) {
                set.add(temp);
            } else {
                boolean b = false;
                for (int num : set) {
                    if (temp > num) {
                        set.add(temp);
                        b = true;
                        break;
                    }
                }
                if (b) {
                    int min = Integer.MAX_VALUE;
                    for (int num : set) {
                        if (num < min) {
                            min = num;
                        }
                    }
                    set.remove(min);
                }
            }
        }

        if (set.size() < 3) {
            int max = Integer.MIN_VALUE;
            for (int num : set) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        } else {
            int min = Integer.MAX_VALUE;
            for (int num : set) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        }
    }
}
