package easy;

import java.util.HashMap;

public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        int result = 0;
        boolean has_odd = false;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                result += map.get(c);
            } else {
                result += map.get(c) - 1;
                has_odd = true;
            }
        }
        if (has_odd) {
            result += 1;
        }
        return result;
    }
}
