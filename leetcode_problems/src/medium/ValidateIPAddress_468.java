package medium;

import java.util.regex.*;

public class ValidateIPAddress_468 {
	public static void main(String args[]) {
		String test = "172.16.254.1";
		String test2 = "172.16.254.255";
		System.out.println(validIPAddress(test2));
	}

	public static String validIPAddress(String queryIP) {
		if (queryIP.length() > 45) {
			return "Neither";
		}
		String ipv4regex = "^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$";
		String ipv6regex = "^([0-9a-fA-F]{1,4}\\:){7,7}([0-9a-fA-F]{1,4})$";

		Pattern ipv4Pattern = Pattern.compile(ipv4regex);
		Matcher ipv4Matcher = ipv4Pattern.matcher(queryIP);
		Pattern ipv6Pattern = Pattern.compile(ipv6regex);
		Matcher ipv6Matcher = ipv6Pattern.matcher(queryIP);

		if (ipv4Matcher.find()) {
			String g1 = ipv4Matcher.group(1);
			String g2 = ipv4Matcher.group(2);
			String g3 = ipv4Matcher.group(3);
			String g4 = ipv4Matcher.group(4);
			// check leading 0
			if (String.valueOf(Integer.valueOf(g1)).length() < g1.length()
					|| String.valueOf(Integer.valueOf(g2)).length() < g2.length()
					|| String.valueOf(Integer.valueOf(g3)).length() < g3.length()
					|| String.valueOf(Integer.valueOf(g4)).length() < g4.length()) {
				return "Neither";
			} else if (Integer.valueOf(g1) > 255 || Integer.valueOf(g1) < 0 || Integer.valueOf(g2) > 255
					|| Integer.valueOf(g2) < 0 || Integer.valueOf(g3) > 255 || Integer.valueOf(g3) < 0
					|| Integer.valueOf(g4) > 255 || Integer.valueOf(g4) < 0) {
				return "Neither";
			} else {
				return "IPv4";
			}

		} else if (ipv6Matcher.find()) {
			return "IPv6";
		} else {
			return "Neither";
		}
	}
}
