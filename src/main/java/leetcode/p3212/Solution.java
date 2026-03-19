package leetcode.p3212;

class Solution {
    // Constraints:
    // Must contain grid[0][0],
    // an equal frequency of 'X' and 'Y',
    // at least one 'X'.
    public int numberOfSubmatrices(char[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final Pair[][] prefixSum = new Pair[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final int xCnt = grid[i][j] == 'X' ? 1 : 0;
                final int yCnt = grid[i][j] == 'Y' ? 1 : 0;

                if (i == 0 && j == 0) {
                    // An init (0, 0) cell
                    prefixSum[i][j] = new Pair(xCnt, yCnt);
                } else if (i == 0) {
                    // 1D prefix-sum (row=0)
                    var prev = prefixSum[i][j - 1];
                    prefixSum[i][j] = new Pair(prev.x + xCnt, prev.y + yCnt);
                } else if (j == 0) {
                    // 1D prefix-sum (col=0)
                    var prev = prefixSum[i - 1][j];
                    prefixSum[i][j] = new Pair(prev.x + xCnt, prev.y + yCnt);
                } else {
                    // 2D prefix-sum
                    var prevRow = prefixSum[i - 1][j];
                    var prevCol = prefixSum[i][j - 1];
                    var prevDiag = prefixSum[i - 1][j - 1];
                    prefixSum[i][j] = new Pair(
                            prevRow.x + prevCol.x + xCnt - prevDiag.x,
                            prevRow.y + prevCol.y + yCnt - prevDiag.y);
                }

                if (prefixSum[i][j].isValidFrequency()) {
                    count++;
                }
            }
        }

        return count;
    }

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isValidFrequency() {
            return x > 0 && x == y;
        }
    }
}
