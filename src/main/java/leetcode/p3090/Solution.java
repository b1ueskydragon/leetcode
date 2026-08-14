package leetcode.p3090;

class Solution {
    // at most two = 0 or 1 or 2 frequencies.
    public int maximumLengthSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxDistance = 0;
        final int n = s.length();
        final int[] freq = new int[26];
        while (l <= r && r < n) {
            if (freq[s.charAt(r) - 'a'] < 2) {
                freq[s.charAt(r) - 'a']++;
                maxDistance = Math.max(maxDistance, r - l + 1);
                r++;
            } else {
                freq[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return maxDistance;
    }
}
