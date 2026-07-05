package leetcode.p2492;

import java.util.Arrays;

class SolutionV2 {
    public int minScore(int n, int[][] roads) {
        final int[] parents = new int[n + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        // componentMin[root] = min edge cost in the connected component.
        final int[] componentMin = new int[n + 1];
        Arrays.fill(componentMin, Integer.MAX_VALUE);
        for (int[] road : roads) {
            final int from = road[0];
            final int to = road[1];
            final int cost = road[2];

            final int fromRoot = find(from, parents);
            final int toRoot = find(to, parents);

            parents[toRoot] = fromRoot;
            // Compare both directions, and the new cost.
            final int minCost = Math.min(componentMin[fromRoot], Math.min(componentMin[toRoot], cost));
            componentMin[fromRoot] = minCost;
            componentMin[toRoot] = minCost;
        }
        // Constraint: There is at least one path between 1 and n.
        // 1 must be included in the route to n.
        // so n needs to refer its root.
        // find(n) == find(1).
        return componentMin[find(n, parents)];
    }

    private int find(int node, int[] parents) {
        if (parents[node] == node) {
            return node; // itself is a root.
        }
        // Path compression.
        int root = find(parents[node], parents);
        // After the recursion, link the node directly to the found root.
        parents[node] = root;
        return root;
    }
}
