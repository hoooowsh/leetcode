package easy;

public class ExcelSheetColumnNumber_171 {
	public static void main(String[] args) {
		titleToNumber("AB");
	}

	public static int titleToNumber(String columnTitle) {
		if (columnTitle == null || columnTitle == "") {
			return 0;
		}
		int result = 0;
		int base = 0;
		for (int i = columnTitle.length() - 1; i >= 0; i--) {
			int cur = columnTitle.charAt(i) - '@';
			base = (int) Math.pow(26, columnTitle.length() - 1 - i);
			result += base * cur;
		}
		return result;
	}
}
