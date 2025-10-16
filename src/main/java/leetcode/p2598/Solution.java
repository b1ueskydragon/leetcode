package leetcode.p2598;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // Due to the constraint, array is not feasible
        final Map<Integer, Integer> freq = new HashMap<>();
        // We can add or subtract any number of times, each number can be shifted by any multiple of value.
        // Thus, all numbers can be normalized to `num % value`
        //
        // Since we are finding the minimum excluded non-negative integer in it,
        // negative num -> should be adjusted to non-negative num (i.o., no subtract, add only)
        // non-negative num -> non-negative num
        //
        // e.g.,
        // nums = [1, -10, 7, 13, 6, 8], value = 7
        // normalized residues = [1, 4, 0, 6, 6, 1]
        for (int num : nums) {
            // When negative num comes,
            // e.g.,
            // num = -10, value = 7
            // -10 % 3 = -3
            // -3 + 7 = 4
            // 4 = (-10 % 7) + 7
            //   = (n % v) + v
            // Generalized; To prevent non-negative num is getting bigger than the value,
            // (n % v) + v = ((n % v) + v) % v
            final int key = ((num % value) + value) % value;
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        // Retrieve 1 from the max limit based on the constraint
        // To find a first hit
        // 要は i がどの在庫に対応しているのかを見つけて見つけ次第 consume する
        for (int i = 0; i <= 100000; i++) {
            final int key = i % value;
            if (freq.get(key) == null || freq.get(key) == 0) {
                return i;
            }
            // Consume the count of residues
            freq.put(key, freq.get(key) - 1);
        }

        return 0; // Not reachable
    }
}
