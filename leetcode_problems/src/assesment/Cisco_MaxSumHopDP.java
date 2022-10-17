package assesment;

public class Cisco_MaxSumHopDP {
	public static void main(String args[]) {
		int[] inputarr = { 5, 30, 99, 60, 5, 10 };
		System.out.println(maxSum(inputarr));
	}

	public static int maxSum(int[] inputArr) {
		// checking special case len0, len1, and len2
		if (inputArr.length == 0) {
			return 0;
		}
		if (inputArr.length == 1) {
			return inputArr[0];
		}
		if (inputArr.length == 2) {
			return Math.max(inputArr[0], inputArr[1]);
		}
		// init dp arr
		int[] dp = new int[inputArr.length + 1];
		dp[0] = 0;
		dp[1] = inputArr[0];
		dp[2] = inputArr[1];

		// looping through inputArr to find maximum
		for (int i = 3; i < dp.length; i++) {
			// these two pos is for dp arrf
			int pos1 = i - 2;
			int pos2 = i - 3;
			dp[i] = Math.max(dp[pos1] + inputArr[i - 1], dp[pos2] + inputArr[i - 1]);
		}
		return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
	}
}
