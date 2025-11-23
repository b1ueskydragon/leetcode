package leetcode.p1262;

class Solution {
    public int maxSumDivThree(int[] nums) {
        // For each num, add it to all three DP slots (DP states).
        // Each sum transitions to a new corresponding slot depending on its new remainder (mod 3).
        //
        // dp[0] = Maximum sum with remainder 0 (mod 3)
        // dp[1] = Maximum sum with remainder 1 (mod 3)
        // dp[2] = Maximum sum with remainder 2 (mod 3)
        int[] dp = new int[3];
        for (int num : nums) {
            int[] tmp = new int[3];

            update(dp[0] + num, tmp);
            update(dp[1] + num, tmp);
            update(dp[2] + num, tmp);

            tmp[0] = Math.max(tmp[0], dp[0]);
            tmp[1] = Math.max(tmp[1], dp[1]);
            tmp[2] = Math.max(tmp[2], dp[2]);

            dp = tmp;
        }
        return dp[0];
    }

    private static void update(int acc, int[] slot) {
        switch (acc % 3) {
            case 0 -> slot[0] = Math.max(slot[0], acc);
            case 1 -> slot[1] = Math.max(slot[1], acc);
            case 2 -> slot[2] = Math.max(slot[2], acc);
        }
    }
}
