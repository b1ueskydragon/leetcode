package leetcode.p1758;

class Solution {
    public int minOperations(String s) {
        // Compare start with 1 pattern to start with 0 pattern.
        // Still O(n) time.
        int head = s.charAt(0) - '0';
        // Head is not flipped VS Head is flipped (Count as 1)
        return Math.min(toggleCount(head, s), toggleCount(head ^ 1, s) + 1);
    }

    private int toggleCount(int prev, String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            if (prev == curr) {
                curr ^= 1; // Treat as toggled
                count++;
            }
            prev = curr;
        }
        return count;
    }
}
