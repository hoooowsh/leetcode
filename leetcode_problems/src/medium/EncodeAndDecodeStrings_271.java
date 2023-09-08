package medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings_271 {
	public ArrayList<Integer> arr;

	// Encodes a list of strings to a single string.
	EncodeAndDecodeStrings_271() {
		arr = new ArrayList<>();
	}

	public String encode(List<String> strs) {
		String result = "";
		for (int i = 0; i < strs.size(); i++) {
			this.arr.add(strs.get(i).length());
			result += strs.get(i);
		}
		return result;
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> result = new ArrayList<>();
		int pos = 0;
		for (int i = 0; i < arr.size(); i++) {
			result.add(s.substring(pos, pos + arr.get(i)));
			pos += arr.get(i);
		}
		return result;
	}
}
