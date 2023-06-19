package leetcode.p1732;

// Beats 100%, O(N) execution time
// O(1) space
class Solution {
    public int largestAltitude(int[] gain) {
        // constraint: the start point is fixed at 0
        int prev = 0;
        int highest = prev;
        for (int x : gain) {
            prev += x;
            highest = Math.max(highest, prev);
        }
        return highest;
    }
}
