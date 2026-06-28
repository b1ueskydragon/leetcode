package leetcode.p1846;

class SolutionV2 implements Solution {
    // 1 <= len(arr) <= 100_000
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Only the decreasing is allowed,
        // so the answer must be less than or equal to len(arr).
        // Rearrange is allowed,
        // so a sorting is feasible.
        // The value of the first element in arr must be 1,
        // so the answer is in range of [1, len(arr)].
        final int limit = arr.length;
        final int[] freq = new int[limit + 1];
        // e.g.,
        // [1, 50, 50, 50, 100, 100]
        // is substantially same as
        // [1, 6, 6, 6, 6, 6]
        for (int num : arr) {
            if (num > limit) {
                freq[limit]++;
            } else {
                freq[num]++;
            }
        }
        // System.out.println(Arrays.toString(freq));
        // e.g.,
        // freq [0, 0, 2, 1, 2, 1, 0, 1, 0, 0, 3]
        // should be converted to [0, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0]
        // another e.g.,
        // freq [0, 1, 0, 0, 0, 0, 5]
        // should be converted to  [0, 1, 1, 1, 1, 1, 1]
        for (int num = 1; num < limit; num++) {
            // if (num == max) {
            //     return max;
            // }
            if (freq[num] < 1) {
                int required = 1 - freq[num];
                freq[num] = 1;
                // Assume that num + 1 is always exists, more than 1 frequency,
                // so negative frequency is allowed at this stage.
                freq[num + 1] -= required;
            }
        }
        // System.out.println(Arrays.toString(freq));
        // e.g.,
        // freq [0, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0]
        // should be converted to [0, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0]
        // another e.g.,
        // freq [0, 2, 3, 1, 1, -2]
        // should be converted to [0, 2, 3, 0, 0, 0]
        for (int num = limit; num >= 1; num--) {
            if (freq[num] > 0) {
                return num;
            }
            freq[num - 1] += freq[num];
        }
        return limit;
    }
}
