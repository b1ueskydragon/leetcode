package leetcode.p2206;

class Solution {
    static class V1 {
        public boolean divideArray(int[] nums) {
            // Constraints: 1 <= n <= 500, 1 <= nums[i] <= 500
            final int[] table = new int[501];
            for (int num : nums) {
                table[num]++;
            }
            for (int count : table) {
                if (count % 2 != 0) {
                    return false; // no need to accumulate anymore
                }
            }
            return true;
        }
    }

    static class V2 {
        public boolean divideArray(int[] nums) {
            // Constraints: 1 <= n <= 500, 1 <= nums[i] <= 500
            // switch the status (0 or 1) dynamically.
            final boolean[] remains = new boolean[501];
            for (int num : nums) {
                // if exists, remove.
                // else, put.
                remains[num] = !remains[num];
            }
            for (boolean y : remains) {
                if (y) {
                    return false;
                }
            }
            return true;
        }
    }
}
