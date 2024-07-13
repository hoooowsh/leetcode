package medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {
    public static void main(String[] args) {
        String test = "a)b(c)d";
        String result = minRemoveToMakeValid(test);
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // if its letter, ignore
            if (arr[i] != '(' && arr[i] != ')') {
                continue;
            }
            // if its parenthesis
            else {
                // if stack empty
                if (stack.empty()) {
                    stack.push(i);
                    continue;
                }

                char prev = arr[stack.peek()];
                if (prev == '(' && arr[i] == ')') {
                    stack.pop();
                    continue;
                }
                stack.push(i);
            }
        }

        for (int pos : stack) {
            arr[pos] = Character.MIN_VALUE;
        }

        String result = "";
        for (char c : arr) {
            if (c != Character.MIN_VALUE) {
                result += c;
            }
        }
        return result;
    }
}
