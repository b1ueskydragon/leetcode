package leetcode.p1356;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
class Solution {

    public int[] sortByBits(int[] arr) {
        // 1 <= arr.length <= 500
        // 1 <= arr[i] <= 10^4 (less than 1 << 14)
        final List[] frequency = new List[14];

        for (int num : arr) {
            int key = bitCount(num);
            if (frequency[key] == null) {
                frequency[key] = new ArrayList<>();
            }
            frequency[key].add(num);
        }
        int i = 0;
        for (List<Integer> list : frequency) {
            if (list == null) {
                continue;
            }
            Collections.sort(list);
            for (int num : list) {
                // Rewrite to arr.
                arr[i++] = num;
            }
        }
        return arr;
    }

    private int bitCount(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>>= 1;
        }
        return count;
    }
}
