package medium;

public class ReverseInteger_7 {
	public static void main(String[] args) {
		int test = reverse2(123);
		System.out.println(test);
	}

	// first version, using string
	public static int reverse(int x) {
		try {
			String inttostring = Integer.toString(x);
			String result = "";
			boolean control = false;
			if (x == 0) {
				return 0;
			}
			for (int i = 0; i < inttostring.length(); i++) {
				if (inttostring.charAt(inttostring.length() - i - 1) == '0' && control == false) {
					continue;
				} else {
					control = true;
					result = result + inttostring.charAt(inttostring.length() - i - 1);
				}
			}
			if (result.charAt(result.length() - 1) == '-') {
				result = "-" + result.substring(0, result.length() - 1);
			}
			return Integer.parseInt(result);
		} catch (Exception e) {
			return 0;
		}
	}

	// second version, using math. Need to convert to long to avoid integer overflow
	public static int reverse2(int x) {
		long result = 0;
		long x2 = (long) x;
		while (Math.abs(x2) >= 10) {
			long temp = x2 % 10;
			x2 = x2 / 10;
			result = result * 10 + temp;
		}
		long temp2 = (long) result * 10 + x2;
		if (temp2 > Integer.MAX_VALUE || temp2 < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) temp2;
	}
}
