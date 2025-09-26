package leetcode.p0120;

import java.util.ArrayList;
import java.util.List;

class Solution {

    static class V2 {

        // If you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
        // O(n) extra space, where n is the total number of rows in the triangle.
        public int minimumTotal(List<List<Integer>> triangle) {
            final int n = triangle.size();
            final int[] prevDp = new int[n];
            final int[] dp = new int[n];
            prevDp[0] = dp[0] = triangle.get(0).get(0);
            for (int r = 1; r < n; r++) {
                final List<Integer> row = triangle.get(r);
                final int rowN = row.size();
                for (int i = 0; i < rowN; i++) {
                    if (i == 0) {
                        dp[i] = prevDp[i] + row.get(i);
                    } else if (i == rowN - 1) {
                        dp[i] = prevDp[i - 1] + row.get(i);
                    } else {
                        dp[i] = Math.min(prevDp[i - 1], prevDp[i]) + row.get(i);
                    }
                }
                for (int i = 0; i < n; i++) {
                    prevDp[i] = dp[i];
                }
            }

            int min = dp[0];
            for (int acc : dp) {
                min = Math.min(acc, min);
            }

            return min;
        }

    }

    static class V1 {

        // If you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
        // 1 + 2 + ... + n = n(n + 1) / 2 ≈ O(n^2) Space usage.
        public int minimumTotal(List<List<Integer>> triangle) {
            final List<List<Integer>> dp = new ArrayList<>();
            final List<Integer> initRow = new ArrayList<>();
            initRow.add(triangle.get(0).get(0));
            dp.add(initRow);

            for (int r = 1; r < triangle.size(); r++) {
                final List<Integer> prevRow = dp.get(r - 1);
                final List<Integer> row = triangle.get(r);
                final List<Integer> newRow = new ArrayList<>();
                dp.add(newRow);

                for (int i = 0; i < row.size(); i++) {
                    // 現在地基準, previous dp row の i 番目 or i-1 番目から持ってくる
                    int prev;
                    if (i == 0) {
                        prev = prevRow.get(i);
                    } else if (i == row.size() - 1) {
                        prev = prevRow.get(i - 1);
                    } else {
                        prev = Math.min(prevRow.get(i), prevRow.get(i - 1));
                    }
                    newRow.add(row.get(i) + prev);
                }
            }

            int min = dp.get(dp.size() - 1).get(0);
            for (int acc : dp.get(dp.size() - 1)) {
                min = Math.min(min, acc);
            }
            return min;
        }

    }

}
