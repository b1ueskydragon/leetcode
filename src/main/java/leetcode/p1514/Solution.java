package leetcode.p1514;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // n (2 <= n <= 10^4) nodes
        // departure -> [edge1, edge2, ... ]
        // edge := [destination, prob]
        // 全然違う個数の edge を持ちうるので, 中身は mutable list.
        final List<Edge>[] depToDest = new List[n];

        // DO NOT USE Arrays#fill for objects. Same reference will be shared across all elements.
        for (int i = 0; i < depToDest.length; i++) {
            // This will prevent NPE.
            depToDest[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int dep = edges[i][0];
            int dest = edges[i][1];
            double prob = succProb[i];
            depToDest[dep].add(new Edge(dest, prob));
            // 双方で通行可能なので逆方向も入れる (そうでないと行けるのにも関わらず empty list になる)
            depToDest[dest].add(new Edge(dep, prob));
        }

        // 大きい prob を優先して引きたい.
        final PriorityQueue<State> pq =
                new PriorityQueue<>((s1, s2) -> Double.compare(s2.probSoFar, s1.probSoFar));

        // The start node cannot reach to the start node itself,
        // however, 掛け算の便宜上 1.
        pq.offer(new State(start_node, 1));

        // The start node -> node までの prob so far のなかで maximum.
        // 全ての prob (possibility) は non-negative, prob 同士の掛け算の min = 0. 最初は未知として 0 で問題ない.
        final double[] maxProbs = new double[n];

        while (!pq.isEmpty()) {
            final var state = pq.poll();
            final int currDep = state.node;
            // 現在の出発地点より直線で行ける全てのノードを調べる.
            for (Edge edge : depToDest[currDep]) {
                final double probSoFar = state.probSoFar * edge.prob;
                if (maxProbs[edge.dest] < probSoFar) {
                    // Update to the best so far.
                    maxProbs[edge.dest] = probSoFar;
                    // 今の start node だったところから辿り着いた nodes が次の start nodes.
                    // そうやって end node まで繋げていく.
                    pq.offer(new State(edge.dest, probSoFar));
                }
                // best ではなかったものは poll されたまま消えていく.
            }
        }
        return maxProbs[end_node];
    }

    // ただのどこかの departure --probability--> destination の記録
    private record Edge(int dest, double prob) {
    }

    // start_node ---色々経て, prob so far---> node の記録
    private record State(int node, double probSoFar) {
    }
}
