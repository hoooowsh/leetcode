package assesment;

public class Cisco_AllIntegersLessThanXAddupToY {
	public static void main(String args[]) {
		int a1 = 20;
		int b1 = 5;
		System.out.println(AllIntegersLessThanXAddupToY(a1, b1));
	}

	public static int AllIntegersLessThanXAddupToY(int x, int y) {
		int result = 0;
		for (int i = 1; i <= x; i++) {
			if (helper(i) == y) {
				result++;
			}
		}
		return result;
	}

	public static int helper(int num) {
		int result = 0;
		while (num > 0) {
			result += num % 10;
			num = num / 10;
		}
		return result;
	}

}
