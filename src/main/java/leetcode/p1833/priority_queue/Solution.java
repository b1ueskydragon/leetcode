package leetcode.p1833.priority_queue;

import java.util.PriorityQueue;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // choose as many small costs as possible
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int cost : costs) {
            pq.offer(cost);
        }
        if (pq.isEmpty()) {
            return 0;
        }
        int count = 0;
        int cap = coins;
        while (cap >= pq.peek()) {
            cap -= pq.poll();
            count++;
            if (pq.isEmpty()) {
                return count;
            }
        }
        return count;
    }
}
