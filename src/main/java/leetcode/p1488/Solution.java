package leetcode.p1488;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] avoidFlood(int[] rains) {
        // 最初に supply された数字が、次同じ数字が supply するまでに一度 consume されないと溢れる.
        // つまり, consume の機会が訪れた時はこれから登場する数字を優先的に consume する必要がある.
        final int n = rains.length;
        // int[] is not effective to write index 10^9, using hashmap
        final Map<Integer, Integer> nextDay = new HashMap<>();

        // e.g.,
        // rains=[1,2,0,1,0,2,0,1]
        // nexts=[3,5,0,7,0,0,0,0]
        final int[] nexts = new int[n];

        // Right to Left
        // Mapping rains[i] -> an index of next rainy day
        for (int i = n - 1; i >= 0; i--) {
            if (rains[i] == 0) {
                continue;
            }
            nexts[i] = nextDay.getOrDefault(rains[i], 0);
            nextDay.put(rains[i], i);
        }

        // int[] is not effective to write index 10^9, using hashmap
        final Map<Integer, Boolean> filled = new HashMap<>();

        // Candidates (Ascending order of next rain day)
        // {nexts[i], rains[i]}
        final PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // ans[i] is the lake you choose to dry
        final int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                if (filled.getOrDefault(rains[i], false)) {
                    return new int[0];
                }
                filled.put(rains[i], true);
                ans[i] = -1;
                if (nexts[i] > 0) {
                    // To prevent using redundant `change of dry`
                    minHeap.offer(new int[]{nexts[i], rains[i]});
                }
            } else {
                // Chance to consume (rains[i] == 0)
                // Note: We can't guarantee that minHeap can offer consumable candidates always
                if (!minHeap.isEmpty()) {
                    final var consume = minHeap.poll();
                    filled.put(consume[1], false);
                    ans[i] = consume[1];
                } else {
                    // There is no target lake to dry
                    // Put any number (constraints)
                    ans[i] = 1;
                }
            }
        }

        return ans;
    }
}
