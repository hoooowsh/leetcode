package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MinimumNumberOfArrowsToBurstBalloons_452 {
    public static void main(String[] args) {

    }

    public static int findMinArrowShots(int[][] points) {
        // Sort the 2d array by the first element first
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (map.keySet().contains(points[i][0])) {
                if (points[i][1] < map.get(points[i][0])) {
                    map.put(points[i][0], points[i][1]);
                }
            } else {
                map.put(points[i][0], points[i][1]);
                arr.add(points[i][0]);
            }
        }

        Collections.sort(arr);

        // Find how many arrows are needed
        int start = arr.get(0);
        int end = map.get(start);
        int arrows = 1;
        for (int i = 1; i < arr.size(); i++) {
            int start_cur = arr.get(i);
            int end_cur = map.get(start_cur);
            if (start_cur > end) {
                arrows++;
                start = start_cur;
                end = end_cur;
            } else {
                start = Math.max(start_cur, start);
                end = Math.min(end, end_cur);
            }
        }
        return arrows;
    }
}
