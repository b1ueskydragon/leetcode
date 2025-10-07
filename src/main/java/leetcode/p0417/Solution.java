package leetcode.p0417;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {

    // 4-neighbor: up, down, left, right
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 最初に確実に Pacific, Atlantic にたどり着けるマスをスタートとして
        // 逆流 (the higher or the equal) していく
        // 4方向 adjacent 全て動けるので注意
        // pacific と接する (0,_) (_, 0),
        // atlantic と接する (m-1, _) (_, n-1) は全て true の状態でスタート (逆流) する

        final int m = heights.length;
        final int n = heights[0].length;

        // Pacific
        // 探索方向 (0,0) -> (m-1, n-1)
        // Starting edges: The first row and The first column
        final boolean[][] reachableToP = reachable(heights, 0, 0);

        // Atlantic
        // 探索方向 (m-1, n-1) -> (0,0)
        // Starting edges: The last row and The last column
        final boolean[][] reachableToA = reachable(heights, m - 1, n - 1);

        final List<List<Integer>> common = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reachableToP[i][j] && reachableToA[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    common.add(tmp);
                }
            }
        }
        return common;
    }

    private static boolean[][] reachable(int[][] heights, int fixedEdgeI, int fixedEdgeJ) {
        final int m = heights.length;
        final int n = heights[0].length;

        // 重複 enqueue 防ぎ
        // This can behave as a `visited` (to avoid visiting again) also.
        final boolean[][] reachable = new boolean[m][n];

        // To retrieve 4-neighbor
        final ArrayDeque<int[]> validPointQueue = new ArrayDeque<>();

        ////// Build a start valid points (Edges) //////

        // The last row
        for (int j = 0; j < n; j++) {
            validPointQueue.addLast(new int[]{fixedEdgeI, j});
            reachable[fixedEdgeI][j] = true;
        }
        // The last column
        for (int i = 0; i < m; i++) {
            validPointQueue.addLast(new int[]{i, fixedEdgeJ});
            reachable[i][fixedEdgeJ] = true;
        }

        ////// Propagate the status to 4 neighbors//////

        while (!validPointQueue.isEmpty()) {
            // reached は海側, 海側 -> 陸側 と逆向き探索
            // neighbors (up, down, left, right) が reached より大なりイコールの場合のみ探索し続けられる
            final int[] reached = validPointQueue.pollFirst();
            final int i = reached[0];
            final int j = reached[1];

            for (int k = 0; k < 4; k++) {
                final int ni = i + dx[k]; // neighbor i
                final int nj = j + dy[k]; // neighbor j

                if (!(ni >= 0 && ni < m && nj >= 0 && nj < n)) {
                    continue;
                }
                // Note: Once we know reachability, we don't need to retrieve again
                if (!reachable[ni][nj] && heights[ni][nj] >= heights[i][j]) {
                    validPointQueue.addLast(new int[]{ni, nj});
                    reachable[ni][nj] = true;
                }
            }
        }

        return reachable;
    }
}

