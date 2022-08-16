package medium;

public class JumpGame2_45 {
	public static void main(String[] args) {
		int[] test = { 2, 3, 1, 1, 4 };
		int test2 = jump2(test);
		System.out.println(test2);
	}

	// first approach using greedy, from leetcode solution
	public static int jump(int[] nums) {
		int result = 0;
		int currentJumpEnd = 0;
		int farthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i == currentJumpEnd) {
				result++;
				currentJumpEnd = farthest;
			}
		}
		return result;
	}

	// my own approach using greedy, basic idea is from the range of current element
	// gives, iterate through it and find the next cur that can give the farthest
	// distance using greedy
	public static int jump2(int[] nums) {
		if (nums.length <= 1) {
			return 0;
		}
		int jumpnum = 0;
		int farthest = 0;
		int jump = 0;
		int cur = 0;
		while (cur < nums.length - 1) {
			// this temp is the farthest point that current position can jump to
			int temp = cur + nums[cur];
			if (temp >= nums.length - 1) {
				jumpnum++;
				return jumpnum;
			}
			int nextcur = 0;
			for (int i = cur + 1; i <= temp; i++) {
				// this temp2 is the farthest point that current position and nextcur added
				// together that can jump to
				int temp2 = nums[i] + i;
				if (temp2 >= nums.length - 1) {
					jumpnum += 2;
					return jumpnum;
				}
				if (temp2 > farthest) {
					farthest = temp2;
					nextcur = i;
				}
			}
			cur = nextcur;
			jumpnum++;
		}

		return jumpnum;
	}
}
