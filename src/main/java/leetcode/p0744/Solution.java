package leetcode.p0744;

class Solution {
    // Constraints: letters is sorted in non-decreasing order.
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        // Initialize as the largest letter greater than target.
        char ans = letters[hi];
        // Edge case.
        if (ans <= target) {
            return letters[0];
        }
        while (lo < hi) {
            // left-aligned center. Do not fix a left in the middle.
            int m = lo + (hi - lo) / 2;
            char letter = letters[m];
            // Not `greater than or equal to` target. Equal cannot be the answer.
            if (letter > target) {
                ans = letter;
                hi = m;
            } else {
                lo = m + 1;
            }
        }
        return ans;
    }
}
