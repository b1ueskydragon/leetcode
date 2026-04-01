package leetcode.p0684;

class Solution {
    // コスト比較よりは, 繋がっているか? : Union-find.
    public int[] findRedundantConnection(int[][] edges) {
        final int n = edges.length + 1; // the number of nodes.
        final int[] parents = new int[n + 1]; // parent of each 1 to n nodes.

        // 最初から完璧な node -> ancestor を構築しない
        // e.g.,
        // [[1,2],[1,3],[2,3],[4,1]]
        // 仮に左が parent, 右が child の場合,
        // 常に完璧を保とうとする場合,[1,2] [1,3] までは ancestor=1 のつもりで作って良かった,
        // しかし, [4,1] の登場で ancestor=4 と前のものをすべて更新する必要がある. cost 高.
        // だから, find しなが更新する.
        // Put itself as its parent.
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int uRoot = find(u, parents);
            int vRoot = find(v, parents);
            if (uRoot != vRoot) {
                // root が違えば union.
                // 一貫してu <- v とする.
                // 必ず root 同士で繋げる.
                parents[vRoot] = uRoot;
            } else {
                // root 同士繋がっている. cycle.
                // 念のため, constraint u != v なので最初から繋がっている root 同士はない.
                return edge;
            }
        }
        return null; // not reachable due to the constraint.
    }

    // find + path compression.
    private int find(int node, int[] parents) {
        if (parents[node] == node) {
            // (1) find a root.
            return node;
        }
        int root = find(parents[node], parents);
        // (2) After return, link the current node directly to the root (update the parent to the root).
        parents[node] = root;
        return root;
    }
}
