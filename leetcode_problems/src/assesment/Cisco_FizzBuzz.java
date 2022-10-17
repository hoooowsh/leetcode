package assesment;

import java.util.ArrayList;
import java.util.List;

public class Cisco_FizzBuzz {
	public static List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i < n + 1; i++) {
			boolean boo3 = i % 3 == 0;
			boolean boo5 = i % 5 == 0;
			if (boo3 && boo5) {
				result.add("FizzBuzz");
				continue;
			} else if (boo3) {
				result.add("Fizz");
				continue;
			} else if (boo5) {
				result.add("Buzz");
				continue;
			} else {
				result.add(String.valueOf(i));
			}
		}
		return result;
	}
}
