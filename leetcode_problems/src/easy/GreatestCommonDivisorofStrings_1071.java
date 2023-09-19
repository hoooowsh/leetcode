package easy;

public class GreatestCommonDivisorofStrings_1071 {
	public String gcdOfStrings(String str1, String str2) {
		String result = "";
		if (str1.length() > str2.length()) {
			for (int i = str2.length(); i >= 0; i--) {
				if (str1.length() % i != 0 || str2.length() % i != 0) {
					continue;
				} else {
					boolean bool = false;
					for (int j = 0; j < str2.length(); j += i) {
						if (!str2.substring(0, i).equals(str2.substring(j, j + i))) {
							bool = true;
							break;
						}
					}
					if (bool) {
						break;
					}
					for (int j = 0; j < str1.length(); j += i) {
						if (!str2.substring(0, i).equals(str1.substring(j, j + i))) {
							bool = true;
							break;
						}
					}
					if (bool) {
						break;
					}
					return str2.substring(0, i);
				}
			}
		} else {
			for (int i = str1.length(); i >= 0; i--) {
				if (str1.length() % i != 0 || str2.length() % i != 0) {
					continue;
				} else {
					boolean bool = false;
					for (int j = 0; j < str1.length(); j += i) {
						if (!str1.substring(0, i).equals(str1.substring(j, j + i))) {
							bool = true;
							break;
						}
					}
					if (bool) {
						break;
					}
					for (int j = 0; j < str2.length(); j += i) {
						if (!str1.substring(0, i).equals(str2.substring(j, j + i))) {
							bool = true;
							break;
						}
					}
					if (bool) {
						break;
					}
					return str1.substring(0, i);
				}
			}
		}
		return result;
	}
}
