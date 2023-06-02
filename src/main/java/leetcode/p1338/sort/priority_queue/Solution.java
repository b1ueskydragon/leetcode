package leetcode.p1338.sort.priority_queue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minSetSize(int[] arr) {
        final int threshold = arr.length / 2;

        final Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.computeIfAbsent(x, k -> 0) + 1);
            if (freq.get(x) >= threshold) {
                return 1;
            }
        }

        final Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (var entry : freq.entrySet()) {
            pq.offer(entry.getValue());
        }

        int sum = 0;
        while (!pq.isEmpty() && sum < threshold) {
            sum += pq.poll();
        }

        return freq.size() - pq.size();
    }
}
