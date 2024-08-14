package medium;

import java.util.Arrays;

public class HIndex_274 {
    public static void main(String[] args) {
        int[] test = { 1, 0, 3, 5, 6 };
        System.out.println(hIndex(test));
    }

    public static int hIndex(int[] citations) {
        // If no publications
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int result = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            // If this one not satisfied, exist the loop
            if (citations[i] < citations.length - i) {
                break;
            } 
            // If it is satisfied, update the result
            else {
                result = citations.length - i;
            }
        }
        return result;
    }
}
