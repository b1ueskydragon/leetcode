package leetcode.p1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionV1 {
    public int[] arrayRankTransform(int[] arr) {
        final int n = arr.length;
        final int[] dest = new int[n];
        System.arraycopy(arr, 0, dest, 0, n);
        Arrays.sort(arr);
        int rank = 0;
        int prev = Integer.MIN_VALUE;
        final Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != prev) {
                rankMap.put(arr[i], ++rank);
            }
            prev = arr[i];
        }
        for (int i = 0; i < n; i++) {
            dest[i] = rankMap.get(dest[i]);
        }
        return dest;
    }
}
