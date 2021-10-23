package leetcode.p0506.priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public String[] findRelativeRanks(int[] score) {
    final Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : score) {
      pq.offer(num);
    }

    final String[] res = new String[score.length];

    if (pq.isEmpty()) {
      return res;
    }

    // set a length as a #peek to get max score
    final int[] dict = new int[pq.peek() + 1];

    int i = 1;
    while (!pq.isEmpty()) {
      dict[pq.poll()] = i++;
    }

    for (int j = 0; j < res.length; j++) {
      final int place = dict[score[j]];
      final String placeStr;
      switch (place) {
        case 1:
          placeStr = "Gold Medal";
          break;
        case 2:
          placeStr = "Silver Medal";
          break;
        case 3:
          placeStr = "Bronze Medal";
          break;
        default:
          placeStr = String.valueOf(place);
      }
      res[j] = placeStr;
    }

    return res;
  }
}
