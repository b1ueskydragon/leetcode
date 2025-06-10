package leetcode.p3442;

class Solution {
    public int maxDifference(String s) {
        // s consists only of lowercase English letters
        final int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            final int i = c - 97;
            freq[i]++;
        }
        // Get a maximum difference
        int maxOdd = 0;
        int minEven = 100; // s.length <= 100
        for (int f : freq) {
            if (f == 0) {
                continue;
            }
            if ((f & 1) == 0) {
                minEven = Math.min(minEven, f);
            } else {
                maxOdd = Math.max(maxOdd, f);
            }
        }
        return maxOdd - minEven;
    }
}
