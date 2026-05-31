package leetcode.p2126;

import java.util.Arrays;

class SolutionV1 implements Solution {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        // Int < 10^5 * 10^5 < Long
        long acc = mass;
        for (int num : asteroids) {
            // Invalid initiation case `min(asteroids) > mass` will be filtered also.
            if (acc < num) {
                return false;
            }
            acc += num;
        }
        return true;
    }

}
