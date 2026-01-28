package leetcode.p3650;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    // 全部を通る必要はなく 0 -> n-1 までの minimum cost path
    public int minCost(int n, int[][] edges) {
        // When u -> v0 (cost w0), u -> v1 (cost v1),
        // graph.get(u) := [(v_0, w_0), (v_1, w_1)]
        final List<List<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2]; // cost
            // normal, u -> v
            graph.get(u).add(new Edge(v, w));

            // reversed, v -> u
            graph.get(v).add(new Edge(u, w * 2));
        }

        /* Dijkstra */
        /* スタートからの累積コストが最小の未確定ノードを選ぶ */

        // 0 -> node にたどり着くまでの最初累積 cost
        // cost 順にソート
        final var pq = new PriorityQueue<State>((s1, s2) -> Integer.compare(s1.weight, s2.weight));
        pq.offer(new State(0, 0));

        // dist[u] := 0 -> u に辿り着くまでの最小累積 cost.
        // Edge, State は一切「最小」を主張せず,「最小」を判断するのは dist のみ.
        final int[] dist = new int[n];
        // Initialize all costs as the max.
        // Each value can be relaxed when the lower cost found.
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            var state = pq.poll();
            int curr = state.node;
            int cost = state.weight;

            if (cost > dist[curr]) {
                // すでに better コストがあるので, 探索せず捨てて OK.
                continue;
            }

            for (Edge neighbor : graph.get(curr)) {
                int nextDest = neighbor.to;
                int nextCost = neighbor.cost;

                // より安い経路が見つかったときだけ更新する
                if (cost + nextCost < dist[nextDest]) {
                    dist[nextDest] = cost + nextCost;
                    // 同じ 0 -> X に対して,
                    // コストが改善されるたびに再度 0 -> X の State (with better cost) が PQ に積まれ,
                    // それを何度か評価するのは正しい.意図された挙動.
                    pq.offer(new State(nextDest, cost + nextCost));
                }
                // worse cost 0 -> X State は PQ に残るが... poll 後は dist との比較により何も更新せず自然に捨てられる.
            }

        }
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }

    // X -> X's neighbor (直接の次)
    // (暗黙的 from := graph.get(u))
    // to:= from -> to
    // cost := from -> to への局所的なコスト
    record Edge(int to, int cost) {
    }

    // 0 -> X (複数の点を経ている可能性もあり)
    // 現在どの node にどの weight (累積コスト) で 0 -> node とたどり着いているのか
    // これ自体が min 累積コストを意味しているわけではない
    record State(int node, int weight) {
    }

}
