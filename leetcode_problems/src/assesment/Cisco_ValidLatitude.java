package assesment;

import java.util.regex.*;

public class Cisco_ValidLatitude {

	public static void main(String args[]) {
		String test1 = "(+89.01, +179.11)";
		String test2 = "(+90, +180)";
		String test3 = "(90, 180)";
		String test4 = "(90., 180)";
		String test5 = "(90.0, 180.1)";
		String test6 = "(85S, 95W)";

		System.out.println(ValidLatitude(test6));
	}

	public static boolean ValidLatitude(String str) {
		String regex = "^[(]([+-]?(\\d+(\\.\\d+)?)),\\s([+-]?(\\d+(\\.\\d+)?))[)]$";
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(str);
		if (m.find()) {
			Double x = Double.valueOf(m.group(2));
			Double y = Double.valueOf(m.group(5));
			if (Math.abs(x) <= 90 && Math.abs(y) <= 180) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
