package leetcode.p1524;

class Solution {
    // n = 10^5, subarrays = (1 + 100000) * 100000 / 2 = 5_000_050_000L,
    // O(n=5000050000) is too big, but O(n=100000) is feasible.
    // odd + even = odd (odd+odd, even+even are even)
    public int numOfSubarrays(int[] arr) {
        // e,g,.
        // arr=[1,2,3,5,8]
        // i=0                            i=1                            i=2
        // (prev_head_val=null=0, even)   (prev_head_val=1, "odd")       (prev_head_val=2, "even")
        // 1+2+3+5+8 (o)                  2+3+5+8 (x) // switched        3+5+8 (x) // not changed
        // 1+2+3+5   (o)                  2+3+5   (x) // switched        3+5   (x) // not changed
        // 1+2+3     (x)                  2+3     (o) // switched        3     (o) // not changed
        // 1+2       (o)                  2       (x) // switched
        // 1         (o)
        // odd:4                          odd:1
        //                                (even-"odd"=odd, prev_even_count=1)
        //
        // even:1                         even:3
        //                                (odd-"odd"=even, prev_odd_count=4-1=3,
        //                                 prev_head_val is odd and discarded from here)
        final int n = arr.length;
        // Dynamic (switchable) counters
        long oddCount = 0;
        long evenCount = 0;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            // e,g,.
            // arr=[1,2,3,5,8]
            // 1 -> 1+2 -> ... -> 1+2+3+5+8
            prefixSum += arr[i];
            if ((prefixSum & 1) == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        long oddCountAcc = oddCount;

        for (int i = 1; i < n; i++) {
            final int prevHeadVal = arr[i - 1];
            // Discard the head from the either counter first
            if ((prevHeadVal & 1) == 1) {
                oddCount--;
            } else {
                evenCount--;
            }
            if ((prevHeadVal & 1) == 1) {
                // oddSum - oddVal = evenSum
                // evenSum - oddVal = oddSum
                // swap
                long tmp = evenCount;
                evenCount = oddCount;
                oddCount = tmp;
            }
            // else,
            // oddSum - evenVal = oddSum
            // evenSum - evenVal = evenSum
            // Do nothing, take over the counter

            oddCountAcc += oddCount;
        }
        return (int) (oddCountAcc % 1_000_000_007);
    }
}
