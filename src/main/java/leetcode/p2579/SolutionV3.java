package leetcode.p2579;

class SolutionV3 {
    // n=1: 1
    // n=2: 1 + (4)
    // n=3: 1 + (4) + (4 + 4)
    // n=4: 1 + (4) + (4 + 4 + 4)
    // X_n = X_{n-1} + 4 * (n - 1)
    // or
    //  X_n = 1 + 4 * Σ[i=1 to n-1] i
    public long coloredCells(int n) {
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        return 1 + 4 * sum;
    }
}
