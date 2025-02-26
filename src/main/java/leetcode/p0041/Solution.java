package leetcode.p0041;

class Solution {
    public int firstMissingPositive(int[] nums) {
        // Constraints
        // Max number は (1 << 31) - 1 だけど, 納めるための nums の max length は 10_000
        // max length を超える number は見なくていい
        final int n = nums.length;
        // bucketsort-wise
        // n + 1 で作るので必ずカバーできる, 一旦 negative や zero 意識せずに作る
        final boolean[] exists = new boolean[n + 1];

        for (int num : nums) {
            if (num <= 0) {
                continue; // no need to write
            }
            if (num > n) {
                continue; // no need to write
            }
            exists[num] = true;
        }

        // only focus to positive numbers
        for (int num = 1; num <= n; num++) {
            if (!exists[num]) {
                return num;
            }
        }

        return n + 1; // nums.length をはみ出る範囲で最も小さい数字
    }
}
