package easy;

public class ExcelSheetColumnTitle_168 {
	public static void main(String[] args) {

	}

	// keep divide by 26, make sure to -1 each time
	public static String convertToTitle(int columnNumber) {
		StringBuilder sb = new StringBuilder();

		while (columnNumber > 0) {
			char add;
			if (columnNumber % 26 == 0)
				add = 'Z';
			else
				add = (char) (columnNumber % 26 + 'A' - 1);

			sb.insert(0, add);
			columnNumber = (columnNumber - 1) / 26;
		}

		return sb.toString();
	}
}
