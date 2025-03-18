package leetcode.p0875;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Σ(piles[i] / k) <= h
        // e.g., piles=[3,6,7,11] h=8,
        // eating more, lessening time: MAX k is 11, which make every piles[i]/k to 1.
        //
        // Constraints:
        // "she eats all of them instead and will not eat any more bananas during this hour"
        // -> so we need rounds a number up to the nearest integer. there is no 0 hour.
        //
        // 3/11 + 6/11 + 7/11 + 11/11
        // = 1 + 1 + 1 + 1 <= 8
        // -> To find the perfect k from big and many numbers, set a Binary search from here.
        int low = 1;
        int high = getMaxPile(piles);
        int perfectK = high;
        while (low <= high) {
            // mid
            int k = low + (high - low) / 2;
            // from the constraints, totalH can reach to max 10^9 * 10^4. this exceeds Integer.MAX_VALUE.
            long totalH = 0;
            for (int p : piles) {
                totalH += ceil(p, k);
            }
            if (totalH <= h) {
                perfectK = k;
                // still, we can try smaller k.
                // even totalH == h, we still can try more.
                high = k - 1;
            } else {
                // we need to increase k.
                low = k + 1;
            }
        }
        return perfectK;
    }

    private static int getMaxPile(int[] piles) {
        int maxP = 0;
        for (int p : piles) {
            maxP = Math.max(p, maxP);
        }
        return maxP;
    }

    private static int ceil(int p, int k) {
        // using
        // Math.ceil((double) p / k)
        // or
        // (p % k == 0) ? p / k : 1 + p / k
        // also work.
        return (p + k - 1) / k;
    }
}
