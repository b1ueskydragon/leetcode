package leetcode.p0424;

class Solution {
    public int characterReplacement(String s, int k) {
        // we don't need to swap directly
        // just calculate the slot
        // each window can be various sizes (可変長ウィンドウ)
        final int n = s.length();
        // we need to set the initial window from the zero index
        int l = 0;
        int r = 0;

        // important: the max frequency of the current valid window
        int maxFreq = 0;
        // Constraints: A-Z
        // important: the frequency counter of the current valid window
        int[] count = new int[26];

        // the max size of the valid window
        int maxValidWindowSize = 0;
        while (r < n) {
            count[s.charAt(r) - 'A']++;

            // This will be updated during the window is valid
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);

            // if not valid, then move l (if not valid, shrink the window)
            // (r - l + 1) represents a size of the window
            // k is a buffer
            while (r - l + 1 > maxFreq + k) {
                count[s.charAt(l) - 'A']--;
                l++;

                // reset the max frequency of the current valid window
                maxFreq = 0;
                for (int freq : count) {
                    maxFreq = Math.max(maxFreq, freq);
                }
            }

            // At this point, the window is valid
            maxValidWindowSize = Math.max(maxValidWindowSize, r - l + 1);
            r++;
        }

        return maxValidWindowSize;
    }
}
