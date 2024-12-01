package medium;

import java.util.Stack;

public class ReverseWordsInAString_151 {

    public static void main(String[] args) {
        String test = "  hello world  ";
        String result = reverseWords(test);
    }

    public static String reverseWords(String s) {
        String result = "";
        String[] arr = s.trim().split("\\s+");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0) {
                result += arr[i];
                continue;
            }
            result += arr[i] + " ";
        }
        return result;
    }
}
