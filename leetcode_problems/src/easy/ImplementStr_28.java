package easy;

public class ImplementStr_28 {
	public static void main(String[] args) {

	}
	public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
			return haystack.indexOf(needle);
		} else {
			return -1;
		}
    }
}
