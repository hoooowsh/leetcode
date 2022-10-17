package assesment;

public class Cisco_AlphabeticOrder {
	public static int funcAlphabeticOrder(String inputSting) {
		int answer = -1;
		// Write your code here
		for (int i = 1; i < inputSting.length(); i++) {
			if (inputSting.charAt(i) - '0' < inputSting.charAt(i - 1) - '0') {
				return i;
			}
		}
		return 0;
	}
}
