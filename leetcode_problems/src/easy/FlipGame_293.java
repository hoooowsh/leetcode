package easy;

import java.util.ArrayList;
import java.util.List;

public class FlipGame_293 {
	public static void main(String[] args) {

	}

	public List<String> generatePossibleNextMoves(String currentState) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i < currentState.length(); i++) {
			if (currentState.charAt(i) == '+' && currentState.charAt(i - 1) == '+') {
				result.add(
						currentState.substring(0, i - 1) + "--" + currentState.substring(i + 1, currentState.length()));
			}
		}
		return result;
	}
}
