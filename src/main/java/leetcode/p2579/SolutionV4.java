package leetcode.p2579;

class SolutionV4 {
    // n=1: 1
    // n=2: 1 + (4)
    // n=3: 1 + (4) + (4 + 4)
    // n=4: 1 + (4) + (4 + 4 + 4)
    // X_n = X_{n-1} + 4 * (n - 1)
    // or
    //  X_n = 1 + 4 * Σ[i=1 to n-1] i
    //      = 1 + 4 * ((1 + (n - 1)) * (n - 1)) / 2
    // Constraints: max n would be 10_000
    // I prefer to avoid O(N) search as possible as I can
    public long coloredCells(int n) {
        final long x = n;
        return 1 + 4 * x * (x - 1) / 2;
    }
}
