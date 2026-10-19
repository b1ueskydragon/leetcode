package leetcode.p3551;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // nums consists of distinct positive integers.
    // 1 <= nums[i] <= 10^9
    // 1 <= nums.length <= 10^5
    public int minSwaps(int[] nums) {
        // 52, 43, 25, 34, 7 (given)
        // 0, 1, 2, 3, 4 (indices)
        // 7, 25, 34, 43, 52 (sorted by the rule)
        // 0, 1, 2, 3, 4 (indices)
        // 4, 2, 3, 1, 0 (original indices)
        // Swap greedily.
        // 4, 2, 3, 1, 0 -> 0, 1, 2, 3, 4
        final int n = nums.length;
        // 9*9 < (1 << 7)
        // 10^9 < (1 << 30)
        // digitSum has priority over num itself, num is a tie-breaker.
        final long[] origin = new long[n];
        final long[] sorted = new long[n];
        for (int i = 0; i < n; i++) {
            final long merged = (digitSum(nums[i]) * 1L << 30) + nums[i];
            origin[i] = merged;
            sorted[i] = merged;
        }
        quickSort(sorted, 0, n - 1);
        final Map<Long, Integer> valueToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIdx.put(sorted[i], i);
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int j = valueToIdx.get(origin[i]);
            if (i != j) {
                // The value is the common key for two indices.
                // Swap will change the original position, so update the map.
                valueToIdx.put(sorted[i], j);
                swap(sorted, i, j);
                swaps++;
            }
        }
        return swaps;
    }

    private void quickSort(long[] nums, int l, int r) {
        final int start = l;
        final int end = r;
        final int m = l + (r - l) / 2; // left-aligned
        // Fix pivots before swap.
        final long center = nums[m];
        // To make l and r completely crossed.
        while (l <= r) {
            while (nums[l] < center) {
                l++;
            }
            while (nums[r] > center) {
                r--;
            }
            if (l <= r) {
                long tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }
        // Now l and r completely crossed.
        if (start < r) {
            // Left-half.
            quickSort(nums, start, r);
        }
        if (l < end) {
            // Right-half.
            quickSort(nums, l, end);
        }
    }

    private void swap(long[] nums, int l, int r) {
        long tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    // the maximum possible digitSum is 9*9=81.
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
