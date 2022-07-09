package easy;

public class AddBinary_67 {
	public static void main(String[] args) {
		String a = "1100";
		String b = "111";
		String c = "1111";
		String d = "1111";
		System.out.println(addBinary(c, d));
	}

	public static String addBinary(String a, String b) {
		if (a.length() == 0) {
			return b;
		}
		if (b.length() == 0) {
			return a;
		}
		// to get which lenth is bigger
		int maxsize = 0;
		int minsize = 0;
		boolean amax = false;
		if (a.length() > b.length()) {
			maxsize = a.length() - 1;
			minsize = b.length() - 1;
			amax = true;
		} else {
			maxsize = b.length() - 1;
			minsize = a.length() - 1;
			amax = false;
		}
		// looping through to do the calculation
		int counter = 0;
		String result = "";
		int add = 0;
		while (counter <= maxsize) {
			// is a is bigger
			if (amax) {
				if (counter <= minsize) {
					int i1 = a.charAt(maxsize - counter) - '0';
					int i2 = b.charAt(minsize - counter) - '0';

					if ((a.charAt(maxsize - counter) - '0') + (b.charAt(minsize - counter) - '0') + add == 0) {
						add = 0;
						result = "0" + result;
					} else if ((a.charAt(maxsize - counter) - '0') + (b.charAt(minsize - counter) - '0') + add == 1) {
						add = 0;
						result = "1" + result;
					} else if ((a.charAt(maxsize - counter) - '0') + (b.charAt(minsize - counter) - '0') + add == 2) {
						add = 1;
						result = "0" + result;
					} else {
						add = 1;
						result = "1" + result;
					}
				} else {
					int temp = (a.charAt(maxsize - counter) - '0') + add;
					if (temp == 0) {
						result = "0" + result;
						result = a.substring(0, maxsize - counter) + result;
						add = 0;
						break;
					} else if (temp == 1) {
						result = "1" + result;
						result = a.substring(0, maxsize - counter) + result;
						add = 0;
						break;
					} else {
						result = "0" + result;
						add = 1;
					}
				}
			}
			// if b is bigger
			else {
				if (counter <= minsize) {
					if ((a.charAt(minsize - counter) - '0') + (b.charAt(maxsize - counter) - '0' + add) == 0) {
						add = 0;
						result = "0" + result;
					} else if ((a.charAt(minsize - counter) - '0') + (b.charAt(maxsize - counter) - '0' + add) == 1) {
						add = 0;
						result = "1" + result;
					} else if ((a.charAt(minsize - counter) - '0') + (b.charAt(maxsize - counter) - '0' + add) == 2) {
						add = 1;
						result = "0" + result;
					} else {
						add = 1;
						result = "1" + result;
					}
				} else {
					int temp = (b.charAt(maxsize - counter) - '0') + add;
					if (temp == 0) {
						result = "0" + result;
						result = b.substring(0, maxsize - counter) + result;
						add = 0;
						break;
					} else if (temp == 1) {
						result = "1" + result;
						result = b.substring(0, maxsize - counter) + result;
						add = 0;
						break;
					} else {
						result = "0" + result;
						add = 1;
					}
				}
			}
			counter++;
		}
		if (add == 1) {
			result = "1" + result;
		}
		return result;
	}
}
