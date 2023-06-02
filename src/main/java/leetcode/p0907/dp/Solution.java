package leetcode.p0907.dp;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int n = arr.length;
        // length of contiguous subarray
        int subn = 0;
        for (int i = 1; i <= n; i++) {
            subn += i;
        }
        final int[] dp = new int[subn];

        // for example, when arr.length is 4, build [4, 4, 4, 4, 3, 3, 3, 2, 2, 1]
        // this help to decide a each [start, end] range in the dynamic programming
        // dp[4] := min(dp[0], dp[1]), dp[0] := dp[4 - 4], dp[1] := dp[0 + 1]
        // dp[7] := min(dp[0], dp[6]), dp[0] := dp[7 - 4 - 3], dp[6] := dp[4 + 1]
        // dp[9] := min(dp[0], dp[8]), dp[0] := dp[9 - 4 - 3 - 2], dp[8] := dp[4 + 3 + 1]
        final int[] level = new int[subn];
        for (int i = n, offset = 0; i >= 1; i--) {
            for (int j = offset; j < i + offset; j++) {
                level[j] = i;
            }
            offset += i;
        }

        // initialize offset accumulations
        int offset = level[0], prevOffset = 0, prevPrevOffset = 0;

        // constraint
        final int k = (int) 1e9 + 7;
        // final result
        int acc = 0;

        for (int i = 0; i < subn; i++) {
            if (i < n) {
                dp[i] = arr[i];
                // prevent an overflow
                acc = acc % k + dp[i] % k;
                continue;
            }

            if (i > 0 && level[i] != level[i - 1]) {
                prevPrevOffset = prevOffset;
                prevOffset = offset;
                offset += level[i];
            }
            int start = i - prevOffset;
            int end = start + prevPrevOffset + 1;

            // recurrence formula
            dp[i] = Math.min(dp[start], dp[end]);

            // prevent an overflow
            acc = acc % k + dp[i] % k;
        }

        return acc % k;
    }
}
