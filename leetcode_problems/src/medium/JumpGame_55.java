package medium;

public class JumpGame_55 {
	public static void main(String[] args) {
		int[] test = { 2, 0, 0 };
		boolean boo = canJump(test);
		System.out.println(boo);
	}

	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		if (nums[0] == 0) {
			if (nums.length == 1) {
				return true;
			}
			return false;
		}
		if (nums.length == 1) {
			return true;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				continue;
			} else if (i == nums.length - 1) {
				for (int j = i - 1; j >= 0; j--) {
					if (nums[j] >= i - j) {
						return true;
					}
				}
			} else {
				boolean canjump = false;
				for (int j = i - 1; j >= 0; j--) {
					if (nums[j] > i - j) {
						canjump = true;
						break;
					}
				}
				if (!canjump) {
					return false;
				} else {
					continue;
				}
			}
		}
		return true;
	}
}
