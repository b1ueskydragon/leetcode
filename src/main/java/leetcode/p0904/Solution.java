package leetcode.p0904;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final int LIMIT = 2;

    public int totalFruit(int[] fruits) {
        // Contiguous pick ... Sliding window

        final int n = fruits.length;
        final Map<Integer, Integer> freq = new HashMap<>();
        int uniqueKeys = 0;
        int l = 0;
        // Contiguous distance
        int distance = 0;
        for (int r = 0; r < n; r++) {
            // Very fresh key for current window
            // Note: When the frequency removed before l++, frequency will be 0 not null
            if (freq.get(fruits[r]) == null || freq.get(fruits[r]) == 0) {
                uniqueKeys++;
            }
            freq.put(fruits[r], freq.getOrDefault(fruits[r], 0) + 1);

            // If not valid, shirink the window and remove the frequency
            if (uniqueKeys > LIMIT) {
                freq.put(fruits[l], freq.get(fruits[l]) - 1);
                // fruits[l] was a unique type in current window
                // Note: Already counted once, frequency will be 0 not null
                if (freq.get(fruits[l]) == 0) {
                    uniqueKeys--;
                }
                l++;
            }
            // If valid, memo the result and keep moving r
            distance = Math.max(distance, r - l + 1);
        }
        return distance;
    }
}
