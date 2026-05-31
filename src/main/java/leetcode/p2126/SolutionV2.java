package leetcode.p2126;

class SolutionV2 implements Solution {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Int < 10^5 * 10^5 < Long
        long acc = mass;
        final int limit = 100_001;
        // Every asteroids[i] and mass are positive.
        // Count sort which is bigger than given mass.
        final int[] freq = new int[limit];
        for (int num : asteroids) {
            if (num <= mass) {
                // Those nums (less than or equal to the mass) can be collided by an original mass.
                // However, for bigger nums than mass, we must accumulate them.
                acc += num;
            } else {
                freq[num]++;
            }
        }
        for (int num = 0; num < limit; num++) {
            long count = freq[num];
            if (count == 0) {
                // No such num in given asteroids.
                continue;
            }
            if (acc < num) {
                return false;
            }
            long next = num * count;
            acc += next;
        }
        return true;
    }

}
