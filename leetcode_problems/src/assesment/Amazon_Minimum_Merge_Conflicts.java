package assesment;

public class Amazon_Minimum_Merge_Conflicts {

    public static int getMinMergeConflicts(String primary, String secondary) {
        // Get internal conflcits first
        // Get conflicts for primary,
        // 'cba' has 3 conflicts, 'b' < 'c', 'a' < 'b', and 'a' < 'c'
        int primary_conflicts = 0;
        for (int i = 0; i < primary.length(); i++) {
            for (int j = i + 1; j < primary.length(); j++) {
                if (primary.charAt(j) < primary.charAt(i)) {
                    primary_conflicts++;
                }
            }
        }
        // Get conflicts for secondary
        int secondary_conflicts = 0;
        for (int i = 0; i < secondary.length(); i++) {
            for (int j = i + 1; j < secondary.length(); j++) {
                if (secondary.charAt(j) < secondary.charAt(i)) {
                    secondary_conflicts++;
                }
            }
        }

        // Get suffix array for primary, need to start it from backward, and the last
        // row will be all 0
        int[][] primary_suf = new int[primary.length() + 1][26];
        for (int i = primary.length() - 1; i >= 0; i--) {
            primary_suf[i] = primary_suf[i + 1].clone();
            int charIndex = primary.charAt(i) - 'a';
            primary_suf[i][charIndex]++;
        }
        // Get suffix array for secondary, need to start it from backward, and the last
        // row will be all 0
        int[][] secondary_suf = new int[secondary.length() + 1][26];
        for (int i = secondary.length() - 1; i >= 0; i--) {
            secondary_suf[i] = secondary_suf[i + 1].clone();
            int charIndex = secondary.charAt(i) - 'a';
            secondary_suf[i][charIndex]++;
        }

        // Real DP
        int m = primary.length();
        int n = secondary.length();
        // DP need to have base case, so we use m+1 and n+1
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    dp[m][n] = 0;
                    continue;
                }

                // If pick from primary, need to canculate conflicts by comparing to secondary
                int cost_primary_total = Integer.MAX_VALUE;
                if (i < m) {
                    int charIndex = primary.charAt(i) - 'a';
                    int cost_primary_temp = 0;
                    for (int temp = 0; temp < charIndex; temp++) {
                        cost_primary_temp += secondary_suf[j][temp];
                    }
                    // Because we pick i from primary, so i+1, the pointer to primary should move by
                    // 1 index
                    cost_primary_total = cost_primary_temp + dp[i + 1][j];
                }

                // If pick from secondary
                int cost_secondary_total = Integer.MAX_VALUE;
                if (j < n) {
                    int charIndex = secondary.charAt(j) - 'a';
                    int cost_secondary_temp = 0;
                    for (int temp = 0; temp < charIndex; temp++) {
                        cost_secondary_temp += primary_suf[i][temp];
                    }
                    // Because we pick i from primary, so i+1, the pointer to primary should move by
                    // 1 index
                    cost_secondary_total = cost_secondary_temp + dp[i][j + 1];
                }
                dp[i][j] = Math.min(cost_primary_total, cost_secondary_total);
            }
        }
        return primary_conflicts + secondary_conflicts + dp[0][0];
    }

    public static void main(String args[]) {
        System.out.println(getMinMergeConflicts("zc", "d")); // Expected: 2
        System.out.println(getMinMergeConflicts("cba", "d")); // Expected: 3
        System.out.println(getMinMergeConflicts("dae", "add"));// Expected: 1
    }
}
