package leetcode.p0781;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int ans : answers) {
            freq.put(ans, freq.getOrDefault(ans, 0) + 1);
        }
        // e.g.,
        // RRBBB covers
        // [1,1,2,2]
        // [1,1,2,2,2]
        //
        // RRBBBGGG covers
        // [1,1,2,2,2,2] (The last two Green rabbits had not answered at all)
        // [1,1,2,2,2,2,2] (The last Green rabbit had not answered at all)
        // [1,1,2,2,2,2,2,2] (All rabbits had answered)
        int res = 0;
        for (var entry : freq.entrySet()) {
            final var other = entry.getKey();
            final var rabbits = entry.getValue();

            // Max accommodation of the count group
            // other + self
            final int unit = other + 1;
            if (unit >= rabbits) {
                res += unit;
            } else {
                // When `x` is a count of rabbits,
                // the number of group = x / unit
                // e.g.,
                // (BBB)(GGG) <--- 2 groups
                // other: 2, rabbits: 4,
                // unit is 3 (2+1),
                // required groups are 4/3 = 2 groups (ceil)
                final int groups = (rabbits + (unit - 1)) / unit;
                res += (unit * groups);
            }
        }
        return res;
    }
}
