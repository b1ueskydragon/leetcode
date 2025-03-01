package leetcode.p0994;

import java.util.ArrayDeque;

class SolutionV2 {
    // 情報伝播の発生源に注目
    // 最初から start point (伝播の始まり) を queue 入れておく必要がある
    // また全部の swap 数をカウントするわけではなく, 伝播した level の数で十分
    public int orangesRotting(int[][] grid) {
        final ArrayDeque<Node> queue = new ArrayDeque<>();
        final int m = grid.length;
        final int n = grid[0].length;

        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.addLast(Node.of(i, j)); // 最初の発信源なので level 0
                }
                if (grid[i][j] == 1) {
                    freshOranges++; // for return -1 check afterwards
                }
            }
        }

        if (freshOranges == 0) {
            return 0; // already rotten or no oranges at all
        }

        int level = -1; // this represents time elapsed

        while (!queue.isEmpty()) {
            int propagators = queue.size(); // fixed parent nodes' count at this level

            while (propagators > 0) { // 1回のループで現在のレベルの要素をまとめて処理
                final Node curr = queue.pollFirst();
                final int i = curr.i;
                final int j = curr.j;

                // 0 なら queue に入れなくて良い
                // ここに入る前にすでに 2 になっていたものも改めて入れなくて良い
                if (i > 0) {
                    // up
                    if (grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                        freshOranges--;
                        queue.addLast(Node.of(i - 1, j));
                    }
                }
                if (j > 0) {
                    // left
                    if (grid[i][j - 1] == 1) {
                        grid[i][j - 1] = 2;
                        freshOranges--;
                        queue.addLast(Node.of(i, j - 1));
                    }
                }
                if (i < m - 1) {
                    // down
                    if (grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                        freshOranges--;
                        queue.addLast(Node.of(i + 1, j));
                    }
                }
                if (j < n - 1) {
                    // right
                    if (grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2;
                        freshOranges--;
                        queue.addLast(Node.of(i, j + 1));
                    }
                }
                propagators--;
            }
            level++;
        }
        return freshOranges > 0 ? -1 : level;
    }

    private static class Node {
        int i;
        int j;

        private Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        static Node of(int i, int j) {
            return new Node(i, j);
        }
    }
}
