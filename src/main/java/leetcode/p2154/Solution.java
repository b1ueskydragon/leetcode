package leetcode.p2154;

class Solution {

    static class V2 {

        public int findFinalValue(int[] nums, int original) {
            int bits = 0;
            for (int num : nums) {
                if (num % original != 0) {
                    continue;
                }

                // Normalize
                int n = num / original;

                // Since `original` keeps doubling,
                // we only keep `n` which represents (1 << k)
                // e.g.,
                // (1 is (1 << 0)), 1 & 0 = 0
                // (2 is (1 << 1)), 2 & 1 = 0
                // (4 is (1 << 2)), 4 & 3 = 0
                // (8 is (1 << 3)), 8 & 7 = 0
                // ...
                if ((n & (n - 1)) != 0) {
                    continue;
                }

                // Use OR rather than plus, to ignore duplicates
                bits |= n;
            }

            // e.g.,
            //    ↓
            // 1 [0] 1 1 1
            //
            // 10111 + 1 = 11000
            // ~10111 = 111...101000
            // 111...101000 & 11000 = 1000
            final int missingBit = ~bits & (bits + 1);

            // Restore from the normalized num
            return original * missingBit;
        }

    }

    static class V1 {

        // 1 <= nums.length <= 1000
        // 1 <= nums[i], original <= 1000
        public int findFinalValue(int[] nums, int original) {
            final boolean[] exists = new boolean[1001];
            for (int num : nums) {
                exists[num] = true;
            }
            while (original <= 1000) {
                if (!exists[original]) {
                    return original;
                }
                original <<= 1;
            }
            return original;
        }

    }

}
