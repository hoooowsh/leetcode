package easy;

public class LengthofLastWord_58 {
	public static void main(String[] args) {
	}

	public int lengthOfLastWord(String s) {
		String[] arr = s.split(" ");
		if (arr.length == 0) {
			return 0;
		}
		return arr[arr.length - 1].length();
	}
}
