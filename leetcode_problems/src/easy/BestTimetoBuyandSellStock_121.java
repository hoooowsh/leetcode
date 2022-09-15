package easy;

public class BestTimetoBuyandSellStock_121 {
	public static void main(String args[]) {

	}

	public static int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int income = 0;
		int min = prices[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - min >= income) {
				income = prices[i] - min;
			}
			if (prices[i] < min) {
				min = prices[i];
			}
		}
		return income;
	}
}
