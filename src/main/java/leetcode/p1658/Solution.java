package leetcode.p1658;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 1 <= nums[i] <= 10_000
    // 1 <= n <= 100_000
    // 1 <= x <= 1_000_000_000
    // Eternally pop from the leftmost/rightmost.
    public int minOperations(int[] nums, int x) {
        // x = 5
        // nums = 1, 1, 4, 2, 3
        // ps   = 1  2  6  8  11
        // ss   = 11 10 9  5  3
        //  1  [2]  6  8   11
        // 11  10   9  5  [3]
        // ---> left len 2 + right len 1 = total 3
        // OR
        //  1  2   6   8   11
        // 11  10  9  [5]   3
        // ---> left len 0 + right len 2 = total 2
        final int n = nums.length;
        final int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (prefixSum[i - 1] + nums[i] > x) {
                break;
            }
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        final int[] suffixSum = new int[n];
        suffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (suffixSum[i + 1] + nums[i] > x) {
                break;
            }
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        // Same value: choose the rightmost index
        final Map<Integer, Integer> rightmostIndex = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (suffixSum[i] == 0) {
                break;
            }
            rightmostIndex.putIfAbsent(suffixSum[i], i);
        }
        // Same value: choose the leftmost index
        final Map<Integer, Integer> leftmostIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == 0) {
                break;
            }
            leftmostIndex.putIfAbsent(prefixSum[i], i);
        }

        // Big enough limit (at most n-remove is possible)
        int minTotal = n + 1;

        for (int i = 0; i < n; i++) {
            // x = left + right
            final int left = prefixSum[i];
            if (left == 0) {
                break;
            }
            if (left == x) {
                // System.out.printf("%s %n", i);
                minTotal = Math.min(minTotal, i + 1);
            }
            final int right = x - left;
            if (right < 0) {
                continue;
            }
            final int j = rightmostIndex.getOrDefault(right, -1);
            if (j == -1) {
                continue;
            }
            // left section: [0, i], right section: [j, n)
            // System.out.printf("%s %s %n", i, j);
            minTotal = Math.min(minTotal, i + 1 + n - j);
        }

        for (int j = n - 1; j >= 0; j--) {
            // x = right + left
            final int right = suffixSum[j];
            if (right == 0) {
                break;
            }
            if (right == x) {
                // System.out.printf("%s %n", j);
                minTotal = Math.min(minTotal, n - j);
            }
            final int left = x - right;
            if (left < 0) {
                continue;
            }
            final int i = leftmostIndex.getOrDefault(left, -1);
            if (i == -1) {
                continue;
            }
            // left section: [0, i], right section: [j, n)
            // System.out.printf("%s %s %n", i, j);
            minTotal = Math.min(minTotal, i + 1 + n - j);
        }

        return minTotal == n + 1 ? -1 : minTotal;
    }
}
