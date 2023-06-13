package medium;

import java.util.Stack;

public class DailyTemperatures_739 {
	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures.length == 0) {
			return temperatures;
		}
		int[] result = new int[temperatures.length];
		// this stack will only store element index of the array
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int index = 0;
		for (int i = 1; i < temperatures.length; i++) {
			while (stack.size() > 0 && temperatures[i] > temperatures[stack.peek()]) {
				int pos = stack.pop();
				result[pos] = i - pos;
			}
			stack.push(i);
		}
		return result;
	}
}
