package leetcode.p2685;

class Solution {
    // 0 <= edges.length <= nC2.
    // every edge in edges, edge[0] != edge[1].
    // undirected.
    public int countCompleteComponents(int n, int[][] edges) {
        // nodes: 0 to n-1.
        final int[] parents = new int[n];
        // init: itself is the parent.
        for (int node = 0; node < n; node++) {
            parents[node] = node;
        }

        // root (index) -> the root component consists of edges
        // final List[] componentList = new List[n];

        // components[root] = the number of edges (the root component consists of the edges).
        final int[] components = new int[n];

        for (int[] edge : edges) {
            final int pu = find(parents, edge[0]);
            final int pv = find(parents, edge[1]);
            final int dest = Math.min(pu, pv);
            final int src = Math.max(pu, pv);
            // Keep the direction manually: `the smaller num <- the larger num`.
            // Link to make a same component.
            if (dest != src) {
                parents[src] = dest;
            }
            // if (componentList[dest] == null) {
            //     componentList[dest] = new ArrayList<>();
            // }
            // componentList[dest].add(edge);
            components[dest]++;
        }

        // Find again to aggregate counts.
        for (int root = 0; root < n; root++) {
            final int superRoot = find(parents, root); // parents[root] is NG. find again.
            if (superRoot != root) {
                components[superRoot] += components[root];
                components[root] = 0;
            }
        }

        // vertices[root] = the number of vertices which composes the root component.
        final int[] vertices = new int[n];
        // A connected component is said to be complete
        // if there exists an edge between every pair of its vertices.
        // e.g.,
        // nodes = { a, b, c, d }
        // If { a, b, c, d } composes a group,
        // 4C2 = 6 edges (a-b, a-c, a-d, b-c, b-d, c-d) must exist.
        for (int node = 0; node < n; node++) {
            vertices[parents[node]]++;
        }

        int count = 0;
        for (int root = 0; root < n; root++) {
            final int nodeCount = vertices[root];
            if (nodeCount == 0) {
                continue;
            }
            final int required = combinationPair(nodeCount);
            final int actual = components[root];
            if (required == actual) {
                count++;
            }
        }
        return count;
    }

    private int find(int[] parents, int node) {
        if (parents[node] == node) {
            return node; // itself is the root.
        }
        // Path compression.
        final int root = find(parents, parents[node]);
        parents[node] = root;
        return root;
    }

    // nC2
    private int combinationPair(int n) {
        return n * (n - 1) / 2;
    }

}
