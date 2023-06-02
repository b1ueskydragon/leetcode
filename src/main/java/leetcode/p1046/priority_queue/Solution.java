package leetcode.p1046.priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int lastStoneWeight(int[] stones) {
    final Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int stone : stones) {
      pq.offer(stone);
    }
    while (pq.size() >= 2) {
      int x = pq.poll();
      int y = pq.poll();
      int diff = Math.abs(y - x);
      if (diff > 0) {
        pq.offer(diff);
      }
    }
    return (pq.isEmpty()) ? 0 : pq.poll();
  }
}
