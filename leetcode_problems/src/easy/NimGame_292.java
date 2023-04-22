package easy;

public class NimGame_292 {
	public static void main(String[] args) {

	}

	// this should just be a math or logic problem

	// a -> me, b -> friend
	// 1 - 3, a win
	// 4, b win
	// 5, a take 1, a win
	// 6, a take 2, a win
	// 7, a take 3, a win
	// 8, whatever a takes, b win
	// 9, a take 1, a win
	// ...
	// so 4, 8, 12... b win, other than these, a win
	public static boolean canWinNim(int n) {
		return n % 4 != 0;
	}
}
