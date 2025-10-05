package leetcode.p0417;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 最初に確実に Pacific, Atlantic にたどり着けるマスをスタートとして
        // 逆流 (the higher or the equal) していく
        // 4方向 adjacent 全て動けるので注意
        // pacific と接する (0,_) (_, 0),
        // atlantic と接する (m-1, _) (_, n-1) は全て true の状態でスタート (逆流) する

        // Pacific
        // (0,0) -> (m-1, n-1)
        final boolean[][] canReachToP = canReachToP(heights);

        // Atlantic
        // (m-1, n-1) -> (0,0)
        final boolean[][] canReachToA = canReachToA(heights);

        final List<List<Integer>> common = new ArrayList<>();

        final int m = heights.length;
        final int n = heights[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachToP[i][j] && canReachToA[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    common.add(tmp);
                }
            }
        }
        return common;
    }

    private static boolean[][] canReachToP(int[][] heights) {
        final int m = heights.length;
        final int n = heights[0].length;
        final boolean[][] canReachToP = new boolean[m][n];
        final boolean[][] visited = new boolean[m][n];

        // 4方向探索用
        final ArrayDeque<int[]> validPointQueue = new ArrayDeque<>();

        ////// Build a start valid points //////

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    validPointQueue.addLast(new int[]{i, j});
                    canReachToP[i][j] = true;
                    visited[i][j] = true;
                }
            }
        }

        ////// Propagate the status to 4 neighbors//////

        while (!validPointQueue.isEmpty()) {
            // reached は海側, 海側 -> 陸側 と逆向き探索
            // neighbors (up, down, left, right) が reached より大なりイコールの場合のみ探索し続けられる
            final int[] reached = validPointQueue.pollFirst();
            final int i = reached[0];
            final int j = reached[1];

            // up
            if (j > 0 && !visited[i][j - 1] && heights[i][j] <= heights[i][j - 1]) {
                validPointQueue.addLast(new int[]{i, j - 1});
                canReachToP[i][j - 1] = true;
                visited[i][j - 1] = true;
            }
            // down
            if (j < n - 1 && !visited[i][j + 1] && heights[i][j] <= heights[i][j + 1]) {
                validPointQueue.addLast(new int[]{i, j + 1});
                canReachToP[i][j + 1] = true;
                visited[i][j + 1] = true;
            }
            // left
            if (i > 0 && !visited[i - 1][j] && heights[i][j] <= heights[i - 1][j]) {
                validPointQueue.addLast(new int[]{i - 1, j});
                canReachToP[i - 1][j] = true;
                visited[i - 1][j] = true;
            }

            // right
            if (i < m - 1 && !visited[i + 1][j] && heights[i][j] <= heights[i + 1][j]) {
                validPointQueue.addLast(new int[]{i + 1, j});
                canReachToP[i + 1][j] = true;
                visited[i + 1][j] = true;
            }
        }

        return canReachToP;
    }

    private static boolean[][] canReachToA(int[][] heights) {
        final int m = heights.length;
        final int n = heights[0].length;
        final boolean[][] canReachToA = new boolean[m][n];
        final boolean[][] visited = new boolean[m][n];

        final ArrayDeque<int[]> validPointQueue = new ArrayDeque<>();

        ////// Build a start valid points //////

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    validPointQueue.addLast(new int[]{i, j});
                    canReachToA[i][j] = true;
                    visited[i][j] = true;
                }
            }
        }

        ////// Propagate the status to 4 neighbors//////

        while (!validPointQueue.isEmpty()) {
            final int[] reached = validPointQueue.pollFirst();
            final int i = reached[0];
            final int j = reached[1];

            // up
            if (j > 0 && !visited[i][j - 1] && heights[i][j - 1] >= heights[i][j]) {
                validPointQueue.addLast(new int[]{i, j - 1});
                canReachToA[i][j - 1] = true;
                visited[i][j - 1] = true;
            }
            // down
            if (j < n - 1 && !visited[i][j + 1] && heights[i][j + 1] >= heights[i][j]) {
                validPointQueue.addLast(new int[]{i, j + 1});
                canReachToA[i][j + 1] = true;
                visited[i][j + 1] = true;
            }
            // left
            if (i > 0 && !visited[i - 1][j] && heights[i - 1][j] >= heights[i][j]) {
                validPointQueue.addLast(new int[]{i - 1, j});
                canReachToA[i - 1][j] = true;
                visited[i - 1][j] = true;
            }
            // right
            if (i < m - 1 && !visited[i + 1][j] && heights[i + 1][j] >= heights[i][j]) {
                validPointQueue.addLast(new int[]{i + 1, j});
                canReachToA[i + 1][j] = true;
                visited[i + 1][j] = true;
            }
        }

        return canReachToA;
    }
}
