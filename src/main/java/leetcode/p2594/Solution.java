package leetcode.p2594;

class Solution {
    // Constraints:
    // All the mechanics (worker or Thread) can repair (process or consume) the cars (job or Task) simultaneously.
    //
    // Notes:
    // smaller ranks[i] should be allocated more, bigger rankes[i] should be allocated less.
    // 1<= ranks[i] <= 100
    //
    // e.g.,
    // ranks=[1,5,8], cars = 6
    // Math.max((1x6^2), (5x0^2), (8x0^2))
    // Math.max((1x5^2), (5x1^2), (8x0^2))
    // Math.max((1x4^2), (5x2^2), (8x0^2))
    // Math.max((1x4^2), (5x1^2), (8x1^2)) <-- the minimum
    // Large and many numbers, binary search would be fit to `search`.
    //
    // no need to sort ranks since we're only calculating total cars fixed in time `t`,
    // each mechanic's contribution (sqrt(t/r)) is calculated independently and summed.
    public long repairCars(int[] ranks, int cars) {
        long theSlowest = 0;
        for (int r : ranks) {
            theSlowest = Math.max(theSlowest, r);
        }
        long low = 1;
        long high = theSlowest * cars * cars;
        long perfectT = 0;
        while (low <= high) {
            // mid is `t`.
            // now we know fixed `t` even it's tentative, we can get each `x` per each `r` ranked mechanic.
            // `x` is the number of car that the `r` ranked mechanic can process.
            // t = r x x^2,
            // x = (t/r)^(1/2)
            long t = low + (high - low) / 2;
            // `t` is a Long type, this may exceed a range of Integer.
            long processedCars = 0;
            for (int r : ranks) {
                long x = (long) Math.sqrt(t / r); // Math#sqrt is fast enough.
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
