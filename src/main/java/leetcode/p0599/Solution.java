package leetcode.p0599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length < list2.length) {
            return findRestaurant(list2, list1);
        }
        final var res = buildIndexList(list1, list2);
        return res.toArray(new String[0]);
    }

    private static List<String> buildIndexList(String[] longerXs, String[] shorterXs) {
        int minSum = Integer.MAX_VALUE;
        List<String> cands = new ArrayList<>();
        final var map = buildIndexMap(longerXs);
        for (int i = 0; i < shorterXs.length; i++) {
            final String key = shorterXs[i];
            if (!map.containsKey(key)) {
                continue;
            }
            final int candSum = map.get(key) + i;
            if (candSum == minSum) {
                cands.add(key);
                continue;
            }
            if (candSum < minSum) {
                minSum = candSum;
                cands = new ArrayList<>() {{
                    add(key);
                }};
            }
        }
        return cands;
    }

    private static Map<String, Integer> buildIndexMap(String[] xs) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < xs.length; i++) {
            map.put(xs[i], i);
        }
        return map;
    }
}
