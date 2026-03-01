package leetcode.p1689;

class Solution {
    public int minPartitions(String n) {
        // Fill each digit with 1.
        // The largest digit is the minimum required.
        // e.g., n = 82734
        // 8 2 7 3 4
        // 1 1 1 1 1
        // 1 1 1 1 1
        // 1   1 1 1
        // 1   1   1
        // 1   1
        // 1   1
        // 1   1
        // 1
        int maxD = 0;
        for (int i = 0; i < n.length(); i++) {
            maxD = Math.max(maxD, n.charAt(i) - '0');
        }
        return maxD;
    }
}
