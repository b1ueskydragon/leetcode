package leetcode.p0003;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        int l = 0;
        // During 'duplicate' -> Cannot move `r` at all.
        int r = 0;
        int best = 0;
        final Map<Character, Integer> freq = new HashMap<>();
        while (r < n) {
            char curr = s.charAt(r);
            // Expand the window as possible as it's valid.
            if (freq.getOrDefault(curr, 0) == 0) {
                freq.put(curr, 1);
                best = Math.max(best, r - l + 1);
                r++;
            }
            // Shrink the window until it becomes valid again.
            else {
                // The head is already passed/counted by `r`. The frequency won't be negative.
                char head = s.charAt(l);
                freq.put(head, freq.get(head) - 1);
                l++;
            }
        }
        return best;
    }
}
