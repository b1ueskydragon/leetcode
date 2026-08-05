package leetcode.p3310;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 有向グラフ -> union find より dfs.
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // [[1,2],[0,2],[0,1],[3,4]]
        // 0 -> [1, 2]
        // 1 -> [2]
        // 3 -> [4]
        // 0 to n nodes.
        final List[] paths = new List[n];
        for (int[] invocation : invocations) {
            // u calls v, u relis on v.
            final int u = invocation[0];
            final int v = invocation[1];
            if (paths[u] == null) {
                paths[u] = new ArrayList<>();
            }
            paths[u].add(v);
        }

        // Whether the node is eventually reachable from k.
        final boolean[] visited = new boolean[n];
        visited[k] = true;
        visit(k, k, paths, visited);

        // In any order is fine.
        final List<Integer> ans = new ArrayList<>();
        for (int[] invocation : invocations) {
            // u calls v, u relis on v.
            final int u = invocation[0];
            final int v = invocation[1];
            // k -> a -> b
            // x -> a (All k, a, b should stay)
            if (!visited[u] && visited[v]) {
                return buildAll(n);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void visit(int start, int k, List[] paths, boolean[] visited) {
        if (paths[start] == null) {
            return;
        }
        final List<Integer> neighbors = paths[start];
        for (int neighbor : neighbors) {
            if (visited[neighbor]) {
                // cycle.
                // `return` will cause unexpetedly early cut.
                continue;
            }
            visited[neighbor] = true;
            visit(neighbor, k, paths, visited);
        }
    }

    private List<Integer> buildAll(int n) {
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }
}
