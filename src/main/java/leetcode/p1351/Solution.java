package leetcode.p1351;

class Solution {

    static class V2 {

        // Perform it in O(n + m)
        public int countNegatives(int[][] grid) {
            final int n = grid.length;
            final int m = grid[0].length;
            int count = 0;
            // From bottom-left to top-right (stair-like).
            int i = n - 1;
            int j = 0;
            while (i >= 0 && j < m) {
                if (grid[i][j] < 0) {
                    // Boundary found.
                    count += m - j;
                    i--;
                } else {
                    j++;
                }
            }
            return count;
        }

    }

    static class V1 {

        public int countNegatives(int[][] grid) {
            // Sorted -> Binary search
            final int n = grid.length;
            final int m = grid[0].length;

            int count = 0;
            for (int i = 0; i < n; i++) {
                final int p = binarySearch(grid[i]);
                count += (grid[i][p] < 0) ? m - p : 0;
            }
            return count;
        }

        // 0 未満 value の中で一番左側の index を見つける.
        // xs is sorted non-increasing order.
        private static int binarySearch(int[] xs) {
            final int target = 0;
            int l = 0;
            int r = xs.length - 1;
            while (l < r) {
                int m = l + (r - l) / 2; // left-align center, do not fix l to m.
                if (xs[m] < target) {
                    // もっと左があるかもしれない.
                    r = m;
                } else {
                    // 右側の探索が必要. 少なくとも今の m よりは右.
                    l = m + 1;
                }
            }
            return l;
        }

    }

}
