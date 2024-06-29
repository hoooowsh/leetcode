package easy;

import java.util.HashMap;

public class FindAnagramMappings_760 {

    public static void main(String[] args) {

    }

    public static int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int j = 0; j < nums1.length; j++) {
            nums2[j] = map.get(nums1[j]);
        }
        return nums2;
    }
}
