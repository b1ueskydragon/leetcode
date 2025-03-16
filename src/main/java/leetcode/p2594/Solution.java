package leetcode.p2594;

class Solution {
    // Constraints:
    // All the mechanics (worker or Thread) can repair (process or consume) the cars (job or Task) simultaneously.
    public long repairCars(int[] ranks, int cars) {
        // smaller ranks[i] should be allocated more,
        // bigger ranks[i] should be allocated less.
        // 1<= ranks[i] <= 100
        final int n = ranks.length;
        final int[] table = new int[101];
        for (int i = 0; i < n; i++) {
            table[ranks[i]]++;
        }
        final int[] ranksAsc = new int[n];
        int j = 0;
        for (int i = 0; i < 101; i++) {
            while (table[i] > 0) {
                ranksAsc[j++] = i;
                table[i]--;
            }
        }
        // e.g.,
        // sorted ranks=[1,5,8], cars = 6
        // Math.max((1x6^2), (5x0^2), (8x0^2))
        // Math.max((1x5^2), (5x1^2), (8x0^2))
        // Math.max((1x4^2), (5x2^2), (8x0^2))
        // Math.max((1x4^2), (5x1^2), (8x1^2)) <-- the minimum
        // Large and many numbers, binary search would be fit to `search`.
        long low = 1;
        long high = ((long) ranksAsc[n - 1]) * cars * cars;
        long perfectT = 0;
        while (low <= high) {
            // mid is `t`
            // now we know fixed `t` even it's tentative, we can get each `x` per each `r` ranked mechanic.
            // `x` is the number of car that the `r` ranked mechanic can process.
            // t = r x x^2,
            // x = (t/r)^(1/2)
            long t = low + (high - low) / 2;
            // `t` is a Long type, this may exceed a range of Integer.
            long processedCars = 0;
            for (int r : ranksAsc) {
                long x = (long) Math.sqrt(t / r);
                processedCars += x;
            }
            if (processedCars >= cars) {
                perfectT = t;
                // Though processedCars are already valid
                // (this includes processedCars == cars)
                // still we can try smaller value.
                high = t - 1;
            } else {
                // we need to try bigger value.
                low = t + 1;
            }
        }
        return perfectT;
    }
}
