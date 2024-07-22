package easy;

import java.util.Arrays;
import java.util.HashMap;

public class SortThePeople_2418 {
    public static void main(String[] args) {
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] result = new String[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            result[result.length - i - 1] = map.get(heights[i]);
        }
        return result;
    }
}
