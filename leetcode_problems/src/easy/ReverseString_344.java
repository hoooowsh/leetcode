package easy;

public class ReverseString_344 {
	public static void main(String[] args) {

	}

	public void reverseString(char[] s) {
		for (int i = 0; i < (s.length + 1) / 2; i++) {
			char temp = s[i];
			s[i] = s[s.length - i - 1];
			s[s.length - i - 1] = temp;
		}
	}
}
