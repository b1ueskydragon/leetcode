package leetcode.p1722;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        final int n = source.length;
        // Represents a connection between indices.
        final int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] pair : allowedSwaps) {
            int from = pair[0];
            int to = pair[1];
            int fromRoot = find(from, parents);
            int toRoot = find(to, parents);
            // root 同士を繋ぐ.
            if (fromRoot != toRoot) {
                parents[toRoot] = fromRoot;
            }
        }

        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final int root = find(i, parents);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(i);
        }

        int diffs = 0;
        for (var indices : map.values()) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int i : indices) {
                freq.putIfAbsent(source[i], 0);
                freq.put(source[i], freq.get(source[i]) + 1);
            }
            for (int i : indices) {
                freq.putIfAbsent(target[i], 0);
                freq.put(target[i], freq.get(target[i]) - 1);
            }
            for (int v : freq.values()) {
                if (v < 0) {
                    // Not meaningful at all.
                    continue;
                }
                diffs += v;
            }
        }
        return diffs;
    }

//    private int find(int v, int[] parents) {
//        if (parents[v] == v) {
//            return v;
//        }
//        return find(parents[v], parents);
//    }

    // With a path compression.
    private int find(int v, int[] parents) {
        if (parents[v] == v) {
            return v;
        }
        parents[v] = find(parents[v], parents);
        return parents[v];
    }
}
