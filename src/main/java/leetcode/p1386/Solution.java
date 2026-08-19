package leetcode.p1386;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //     1 2 3 4 5 6 7 8 9 10
    // (1) 0 0 0 0 0 0 0 0 0 0
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // reserved = 1
        // e.g.,
        // n = 3, 
        // reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]],
        // can be compressed to:
        // row_1 -> 0110000100
        // row_2 -> 0000010000
        // row_3 -> 1000000001
        final Map<Integer, Integer> rows = new HashMap<>();
        for (int[] p : reservedSeats) {
            if (rows.get(p[0]) == null) {
                rows.put(p[0], 0);
            }
            int b = 1 << (10 - p[1]);
            rows.put(p[0], rows.get(p[0]) | b);
        }

        // Free rows. Max 2 chunks can be occupied.
        final int idleRows = n - rows.size();

        //      6789     
        // 0000 1111 0
        final int rightParity = (1 << 1) + (1 << 2) + (1 << 3) + (1 << 4);
        //    4567     
        // 00 1111 000            
        final int midParity = rightParity << 2;
        // 2345
        // 1111 00000            
        final int leftParity = midParity << 2;

        int count = 0;
        // len(reservedSeats) <= 10^4. 
        // O(n) is feasible.
        for (var entry : rows.entrySet()) {
            final int bit = entry.getValue();

            final boolean leftIdle = (bit | leftParity) == bit + leftParity;
            final boolean rightIdle = (bit | rightParity) == bit + rightParity;
            final boolean midIdle = (bit | midParity) == bit + midParity;

            if (leftIdle && rightIdle) {
                // The only case be able to count as 2.
                count += 2;
            } else if (leftIdle || midIdle || rightIdle) {
                // Others will be 1 since the overlap.
                count++;
            }
        }

        return idleRows * 2 + count;
    }
}
