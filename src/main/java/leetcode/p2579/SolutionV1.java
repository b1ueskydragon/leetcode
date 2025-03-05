package leetcode.p2579;

class SolutionV1 {
    // n=1: 1
    // n=2: 1 + (4)
    // n=3: 1 + (4) + (4 + 4)
    // n=4: 1 + (4) + (4 + 4 + 4)
    // X_n = X_{n-1} + 4 * (n - 1)
    public long coloredCells(int n) {
        if (n == 1) {
            return 1;
        }
        return coloredCells(n - 1) + 4 * (n - 1);
    }
}
