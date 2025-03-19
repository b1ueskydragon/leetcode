package leetcode.p0137;

class Solution {
    // Constraints:
    // O(N) time, O(1) space.
    // 3 times or exactly once.
    // Big (32 bits) pos and neg numbers with 1 <= nums.length <= 30000
    public int singleNumber(int[] nums) {
        // e.g, 2,1,5,2,1,5,2,1,5
        // 00...010 (2)
        // 00...001 (1)
        // 00...101 (5)
        // 00...010 (2)
        // 00...001 (1)
        // 00...101 (5)
        // 00...010 (2)
        // 00...001 (1)
        // 00...101 (5)
        // -------------------------------
        // `1` x3, `1` x3, `1` x6
        // but when 011 (3) comes,
        // -------------------------------
        // `1` x3, `1` x4, `1` x7
        //
        // Each index represents the count of THAT position's bit.
        // However, the count of rightmost bit will be set the leftmost end
        // (Subsequent calculation will be easier).
        final int[] bits = new int[32];
        for (int num : nums) {
            // Important:
            // We need to use signed right shift,
            // to handle negative number as a negative number.
            // e.g.,
            // 11111111 11111111 11111111 11111011 should be treated as -5
            // not as a positive long type nubmer.
            // Note:
            // O(32 * N) is O(N).
            for (int i = 0; i < 32; i++) {
                // Remove the right-most bit, shift left again,
                // get a `diff` with a original num by using XOR.
                bits[i] += (num ^ ((num >> 1) << 1));
                num >>= 1;
            }
        }
        // Find and collect positions that the bit counts are not a multiple of 3.
        int acc = 0;
        int k = 0;
        for (int bit : bits) {
            // The leftmost place represents the rightmost bit
            if (bit % 3 != 0) {
                acc += (1 << k);
            }
            k++;
        }
        return acc;
    }
}
