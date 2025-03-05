package leetcode.p2579;

class SolutionV2 {
    // n=1: 1
    // n=2: 1 + (4)
    // n=3: 1 + (4) + (4 + 4)
    // n=4: 1 + (4) + (4 + 4 + 4)
    // X_n = X_{n-1} + 4 * (n - 1)
    public long coloredCells(int n) {
        long acc = 1;
        int level = 1; // Constrains: max level is 100_000
        while (level <= n) {
            acc = acc + 4 * (level - 1);
            level++;
        }
        return acc;
    }
}
