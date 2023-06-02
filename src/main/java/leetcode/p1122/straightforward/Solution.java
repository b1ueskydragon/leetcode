package leetcode.p1122.straightforward;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // Ordering of items in arr1 are the same as in arr2.
    // The elements of arr2 are distinct.
    // All elements in arr2 are also in arr1.
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr2) {
            countMap.put(num, 0);
        }

        final List<Integer> diffs = new ArrayList<>();
        for (int num : arr1) {
            // check if the num is only in arr1
            if (!countMap.containsKey(num)) {
                diffs.add(num);
            } else {
                countMap.put(num, countMap.get(num) + 1);
            }
        }

        Collections.sort(diffs);

        final int[] res = new int[arr1.length];
        int start = 0;
        for (int num : arr2) {
            final int count = countMap.get(num);
            int end = start + count;
            for (int i = start; i < end; i++) {
                res[i] = num;
            }
            start += count;
        }

        for (int i = 0; i < diffs.size(); i++) {
            res[i + start] = diffs.get(i);
        }

        return res;
    }
}
