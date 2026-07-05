package leetcode.p2492;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionV1 {
    public int minScore(int n, int[][] roads) {
        // graph[from] = [(to_1, cost_1), ... , (to_n, cost_n)]
        @SuppressWarnings("unchecked")
        final List<int[]>[] graph = new List[n + 1];
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int cost = road[2];
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }
            graph[from].add(new int[]{to, cost});
            // Bidirectional.
            if (graph[to] == null) {
                graph[to] = new ArrayList<>();
            }
            graph[to].add(new int[]{from, cost});
        }
        // bestMin[to] = min cost from the start
        final int[] bestMin = new int[n + 1];
        Arrays.fill(bestMin, Integer.MAX_VALUE);
        // [start to curr, cost so far]
        // Propagate the min, Priority Queue is unnecessary.
        final var queue = new ArrayDeque<int[]>();
        queue.addLast(new int[]{1, Integer.MAX_VALUE});
        while (!queue.isEmpty()) {
            final int[] state = queue.pollFirst();
            int curr = state[0];
            int costSoFar = state[1];
            if (costSoFar > bestMin[curr]) {
                // Skip (discard) stale queue entries.
                //
                // e.g.,
                // curr node = 4, bestMin[4]=5, stale entry (node=4, costSoFar=100) が queue に残っていると仮定.
                // edge 4 -> 5 の cost=50 だとする.
                // bestMin[4]=5 という更新は必ず queue への push を伴うので,
                // entry (node=4, costSoFar=5) は "まだ queue に残っている" or "すでに処理済み" のいずれか.
                //
                // どちらであっても node 4 -> 4's neighbors は costSoFar=5 という最良の状態で
                // 必ず "will be evaluated" or "have already been evaluated".
                //
                // Stale entry (node=4, costSoFar=100) を discard しても
                // node 4's neighbors を評価する機会は失われない.
                continue;
            }
            if (graph[curr] == null) {
                // No neighbors from the curr.
                continue;
            }
            for (int[] edge : graph[curr]) {
                final int neighbor = edge[0];
                final int cost = edge[1];
                final int newCostSoFar = Math.min(costSoFar, cost);
                // Only offer "strictly less than the preserved cost" to the queue.
                // Otherwise, skip (discard). No need to check "visited".
                if (bestMin[neighbor] > newCostSoFar) {
                    bestMin[neighbor] = newCostSoFar;
                    queue.addLast(new int[]{neighbor, newCostSoFar});
                }
            }
        }
        return bestMin[n];
    }
}
