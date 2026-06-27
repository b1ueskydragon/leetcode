package leetcode.p3020;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        // To build a valid subset, we need more than two seed nums always.
        // e.g.,
        // 2, 2
        // 4, 4
        // 16, 16
        // 256
        // ---> 2, 4, 16, 256, 16, 4, 2
        // 2
        // 4, 4
        // 16, 16
        // 256
        // ---> 4, 16, 4
        final int limit = 1_000_000_000;
        final Map<Long, Integer> freq = new HashMap<>();
        int seedLimit = 1;
        for (int num : nums) {
            seedLimit = Math.max(seedLimit, num);
            long n = num * 1L;
            freq.putIfAbsent(n, 0);
            freq.put(n, freq.get(n) + 1);
        }
        seedLimit = (int) Math.sqrt(seedLimit);
        // seed=1 is an edge case.
        // 1,1,1,1,1,...,1
        int ones = freq.getOrDefault(1L, 0);
        // Since there must be only one terminal num, the answer is always odd.
        ones = (ones & 1) == 0 ? ones - 1 : ones;
        int max = Math.max(ones, 1);
        for (long seed = 2; seed <= seedLimit; seed++) {
            if (freq.getOrDefault(seed, 0) < 2) {
                continue;
            }
            long x = seed;
            int cand = 0;
            while (x <= limit) {
                final int cnt = freq.getOrDefault(x, 0);
                if (cnt >= 2) {
                    cand += 2;
                } else if (cnt == 1) {
                    // terminal
                    cand += 1;
                    break;
                } else {
                    // cnt is zero. This is also the terminal.
                    break;
                }
                x *= x;
            }
            // More than one terminal nums, count only one.
            // Since there must be only one terminal num, the answer is always odd.
            cand = (cand & 1) == 0 ? cand - 1 : cand;
            max = Math.max(max, cand);
        }
        return max;
    }
}
