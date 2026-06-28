package leetcode.p1846;

import java.util.Arrays;

class SolutionV1 implements Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Only the decreasing is allowed,
        // so the answer must be less than or equal to len(arr).
        // Rearrange is allowed,
        // so a sorting is feasible.
        Arrays.sort(arr);
        // The value of the first element in arr must be 1.
        arr[0] = 1;
        int prev = arr[0];
        final int n = arr.length;
        for (int i = 1; i < n; i++) {
            final int diff = Math.abs(arr[i] - prev);
            if (diff > 1) {
                arr[i] = prev + 1;
            }
            prev = arr[i];
        }
        return arr[n - 1];
    }
}
