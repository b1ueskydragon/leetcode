package leetcode.p0743;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    // 1 to n.
    public int networkDelayTime(int[][] times, int n, int k) {
        // A fixed array of the mutable list object.
        // graph[from] = [(to_1, cost_1), ... , (to_n, cost_n)]
        @SuppressWarnings("unchecked")
        final List<Edge>[] graph = new List[n + 1];
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int cost = time[2];
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }
            graph[from].add(new Edge(to, cost));
        }

        final var pq = new PriorityQueue<State>(
                (s1, s2) -> Integer.compare(s1.costSoFar, s2.costSoFar));
        // The start point.
        pq.offer(new State(k, 0));

        // distance[node] = start -> node に至るまでの minimum cost を記録.
        final int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // Constraint: 自分自身を結ぶ path は存在しない.
        // Sentinel
        distance[k] = 0;

        while (!pq.isEmpty()) {
            var s = pq.poll();
            int curr = s.curr;
            int costSoFar = s.costSoFar;

            // Skip stale state.
            // With non-negative edge costs (Dijkstra's constraint),
            // extending a worse path cannot lead to a better result.
            if (costSoFar > distance[curr]) {
                continue;
            }

            // No neighbors from the curr.
            if (graph[curr] == null) {
                continue;
            }

            for (Edge edge : graph[curr]) {
                int neighbor = edge.to;
                int cost = edge.cost;

                // curr -> neighbor を結ぶための
                // costSoFar + cost VS 他に通ってきた道の cost
                if (costSoFar + cost < distance[neighbor]) {
                    distance[neighbor] = costSoFar + cost;
                    pq.offer(new State(neighbor, costSoFar + cost));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // We must visit all nodes from the start point.
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, distance[i]);
        }

        return ans;
    }

    // from -- (cost) --> to
    // from -> to を結ぶ1本の辺.
    record Edge(int to, int cost) {
    }

    // start node -- (costSoFar) --> curr
    // start -> curr まで、いくつかの edge を積み重ねた結果.
    record State(int curr, int costSoFar) {
    }
}
