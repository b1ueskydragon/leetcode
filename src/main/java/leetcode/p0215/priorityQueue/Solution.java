package leetcode.p0215.priorityQueue;

import java.util.PriorityQueue;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      // keep size k with natural order
      if (pq.size() < k) {
        pq.offer(num);
        continue;
      }
      if (pq.peek() < num) {
        pq.poll();
        pq.offer(num);
      }
    }
    return pq.peek();
  }
}
