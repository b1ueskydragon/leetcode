package leetcode.p2492;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    // Every from, to, cost is positive. --> Dijkstra is feasible.
    public int minScore(int n, int[][] roads) {
        // graph[from] = [(to_1, cost_1), ... , (to_n, cost_n)]
        final List<int[]>[] graph = new List[n + 1];
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int cost = road[2];
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }
            graph[from].add(new int[]{to, cost});
            // bidirectional
            if (graph[to] == null) {
                graph[to] = new ArrayList<>();
            }
            graph[to].add(new int[]{from, cost});
        }
        // minCost[to] = min cost from the start
        final int[] minCost = new int[n + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        // [start to curr, cost so far]
        final var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{1, Integer.MAX_VALUE});
        while (!pq.isEmpty()) {
            final int[] state = pq.poll();
            int curr = state[0];
            int costSoFar = state[1];
            if (costSoFar > minCost[curr]) {
                // Discard stale entry .
                // Won't be updated to the better one.
                // curr の再更新は この loop の中ではなく,
                // curr が neighbor の立場で relaxation される別の iterationで起こる.
                continue;
            }
            if (graph[curr] == null) {
                // No neighbors from the curr.
                continue;
            }
            for (int[] edge : graph[curr]) {
                int neighbor = edge[0];
                int cost = edge[1];
                int newCostSoFar = Math.min(costSoFar, cost);
                // Only offer "strictly less than the preserved cost" to the queue.
                // Otherwise, skip (discard). No need to check "visited".
                if (minCost[neighbor] > newCostSoFar) {
                    minCost[neighbor] = newCostSoFar;
                    pq.offer(new int[]{neighbor, newCostSoFar});
                }
            }
        }
        return minCost[n];
    }
}
