package leetcode.p2257;

class Solution {
    // All the positions in guards and walls are unique.
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        // 広がらずに, 直進のみなので Not BFS but Brute force

        final char[][] grid = new char[m][n];
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 'g';
        }
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 'w';
        }

        for (int[] g : guards) {
            int x = g[0];
            int y = g[1];

            // up
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == 'w' || grid[i][y] == 'g') {
                    break;
                }
                grid[i][y] = 'v'; // Visited (Guarded). Separated with the guard `g` itself.
            }

            // down
            for (int i = x + 1; i < m; i++) {
                if (grid[i][y] == 'w' || grid[i][y] == 'g') {
                    break;
                }
                grid[i][y] = 'v';
            }

            // left
            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == 'w' || grid[x][j] == 'g') {
                    break;
                }
                grid[x][j] = 'v';
            }

            // right
            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == 'w' || grid[x][j] == 'g') {
                    break;
                }
                grid[x][j] = 'v';
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
