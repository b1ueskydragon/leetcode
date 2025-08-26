package leetcode.p3000;

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxDiagonalArea = 0; // Not the maximum area
        for (int[] dimension : dimensions) {
            final int curr = pythagorasWithoutSqrt(dimension[0], dimension[1]);
            if (maxDiagonal == curr) {
                maxDiagonalArea = Math.max(maxDiagonalArea, dimension[0] * dimension[1]);
                continue;
            }
            if (maxDiagonal < curr) {
                maxDiagonal = curr;
                maxDiagonalArea = dimension[0] * dimension[1];
            }
        }
        return maxDiagonalArea;
    }

    // Constraint: The maximum is 100 * 100 + 100 * 100 = 20000 (Integer)
    private static int pythagorasWithoutSqrt(int a, int b) {
        return a * a + b * b;
    }
}
