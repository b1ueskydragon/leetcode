package leetcode.p1523;

// Beats 100% time execution
// Find rules first based on whether both ends are even or odd
class Solution2023 implements Solution {
    // constraints: 0 <= low <= high <= 10^9
    public int countOdds(int low, int high) {
        return (high - low) / 2 + (isEven(high) && isEven(low) ? 0 : 1);
    }

    // includes zero
    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
