package medium;

public class StringCompression_443 {
	public int compress(char[] chars) {
		if (chars.length == 0) {
			return 0;
		}
		int pointer = 1;
		int counter = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] != chars[i - 1]) {
				if (counter > 1) {
					String temp = String.valueOf(counter);
					counter = 1;
					for (int j = 0; j < temp.length(); j++) {
						chars[pointer] = temp.charAt(j);
						pointer++;
					}
					chars[pointer] = chars[i];
					pointer++;
				} else {
					chars[pointer] = chars[i];
					pointer++;
					continue;
				}
			} else {
				counter++;
			}
		}
		if (counter > 1) {
			String temp = String.valueOf(counter);
			counter = 1;
			for (int j = 0; j < temp.length(); j++) {
				chars[pointer] = temp.charAt(j);
				pointer++;
			}

		}
		return pointer;
	}
}
