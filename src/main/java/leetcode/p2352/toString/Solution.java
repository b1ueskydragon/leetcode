package leetcode.p2352.toString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        final Map<String, Integer> countMap = new HashMap<>();
        final int N = grid.length;
        for (int i = 0; i < N; i++) {
            int[] array = new int[N];
            int k = 0;
            for (int j = 0; j < N; j++) {
                array[k++] = grid[i][j];
            }
            final String key = Arrays.toString(array);
            countMap.put(key, countMap.computeIfAbsent(key, ignore -> 0) + 1);
        }
        int pair = 0;
        for (int j = 0; j < N; j++) {
            int[] array = new int[N];
            int k = 0;
            for (int i = 0; i < N; i++) {
                array[k++] = grid[i][j];
            }
            final String key = Arrays.toString(array);
            if (countMap.containsKey(key)) {
                pair += countMap.get(key);
            }
        }
        return pair;
    }
}
