package leetcode.p2914;

class Solution {
    // Partition into one or more substrings.
    // Each substring has an even length.
    // Each substring contains only 1's or only 0's.
    // s has an even length.
    public int minChanges(String s) {
        // Observation: partition into smaller (min-len is 2), change lesser.
        final int n = s.length();
        int count = 0;
        for (int i = 1; i < n; i = i + 2) {
            char left = s.charAt(i - 1);
            char right = s.charAt(i);
            if (left != right) {
                count++;
            }
        }
        return count;
    }
}
