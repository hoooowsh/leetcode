package medium;

import java.util.ArrayList;

public class FindtheWinneroftheCircularGame_1823 {

	public static void main(String args[]) {
		int test = findTheWinner2(5, 2);
		System.out.println(test);
	}

	public static int findTheWinner(int n, int k) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(i + 1);
		}
		int curpos = 0;
		while (arr.size() > 1) {
			curpos += k - 1;
			curpos = curpos % arr.size();
			arr.remove(curpos);
		}
		return arr.get(0);
	}

	// math approach, not sure why
	public static int findTheWinner2(int n, int k) {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = (ans + k) % i;
		}
		return ans + 1;
	}
}
