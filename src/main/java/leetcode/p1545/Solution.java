package leetcode.p1545;

class Solution {
    //S_n = S_(n-1) + '1' + reverse(invert(S_(n-1)))
    public char findKthBit(int n, int k) {
        // k is 1-indexed.
        // Pass k-1 in advance to address it as a 0-indexed in the recursion.
        return findKthBit(n, k - 1, 0) == 0 ? '0' : '1';
    }

    private int findKthBit(int n, int k, int flipCount) {
        if (k == 0 || n == 1) {
            // Base case.
            // - The first element of any S_i
            // - S_1
            // Those are always '0' due to the constraint.
            //
            // Odd flip counts = flip (0 -> 1)
            // Even flip counts = non-flip (0 -> 0)
            return 0 ^ (flipCount & 1);
        }
        // Always odd.
        int totalSize = (1 << n) - 1;
        // Generally left-aligned center, but it always points the middle due to the odd length.
        int mid = totalSize / 2;
        if (mid == k) {
            // Base case.
            // The center value is always '1' due to the constraint.
            //
            // Odd flip counts = flip (1 -> 0)
            // Even flip counts = non-flip (1 -> 1)
            return 1 ^ (flipCount & 1);
        }
        if (mid > k) {
            // e.g.,
            //           k
            // S_3 = 01  1  1001
            // corresponds to
            // S_2 = 01  1
            //           k
            return findKthBit(n - 1, k, flipCount);
        } else {
            // e.g.,
            // Define totalSize as N,
            //                   k
            // S_4 = 0111001101  1  0001
            // corresponds to
            // S_3 = 0111  0  0110110001
            //           N-k-1
            // And needs to flip.
            return findKthBit(n - 1, totalSize - k - 1, flipCount + 1);
        }

    }
}
