package leetcode.p2352.hashCode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        final int N = grid.length;
        for (int i = 0; i < N; i++) {
            int[] array = new int[N];
            int k = 0;
            for (int j = 0; j < N; j++) {
                array[k++] = grid[i][j];
            }
            final int key = hashCode(array);
            countMap.put(key, countMap.computeIfAbsent(key, ignore -> 0) + 1);
        }
        int pair = 0;
        for (int j = 0; j < N; j++) {
            int[] array = new int[N];
            int k = 0;
            for (int i = 0; i < N; i++) {
                array[k++] = grid[i][j];
            }
            final int key = hashCode(array);
            if (countMap.containsKey(key)) {
                pair += countMap.get(key);
            }
        }
        return pair;
    }

    private static int hashCode(int[] a) {
        int result = 1;
        for (int element : a) {
            // 31 * i == (i << 5) - i
            // constraints: max element is 100000 (17 binary digits)
            result = (result << 17) - result + element;
        }
        return result;
    }
}
