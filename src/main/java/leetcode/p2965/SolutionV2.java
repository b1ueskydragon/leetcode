package leetcode.p2965;

class SolutionV2 {
    // S represents a regular sum: Σ[i=1 to n] i
    // S^2 represents a sum or squares: Σ[i=1 to n] i^2
    // S'-S = a-b, while a is a doubled number and b is an absent number
    // (a+b)(a-b) = a^2 - b^2
    // S'^2 - S^2 = a^2 - b^2
    // a+b = (S'^2 - S^2) / (S'-S)
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // Constraints: n*n grid, max 50x50 grid, other numbers should be unique
        final int n = grid.length;
        final int maxNum = n * n;

        int toBeRegularSum = 0; // S, to-be regular sum
        int asIsRegularSum = 0; // S', as-is regular sum

        // Based on constrains, no concern of overflow, using int is enough
        int toBeSquaresSum = 0; // S^2, to-be sum of squares
        int asIsSquaresSum = 0; // S'^2, as-is sum of squares

        for (int i = 1; i <= maxNum; i++) {
            toBeRegularSum += i;
            toBeSquaresSum += i * i;
        }

        // However we need to retrieve all from (0,0) to (n-1,n-1)
        // O(N^2) time
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int x = grid[i][j];
                asIsRegularSum += x;
                asIsSquaresSum += x * x;
            }
        }

        // a+b = (S'^2 - S^2) / (S'-S)
        final int abSum = (asIsSquaresSum - toBeSquaresSum) / (asIsRegularSum - toBeRegularSum);
        // a-b = S'-S
        final int abSub = asIsRegularSum - toBeRegularSum;

        // equation
        final int a = (abSum + abSub) / 2;
        final int b = abSum - a;

        return new int[] {a, b};
    }
}
