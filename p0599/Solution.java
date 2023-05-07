package leetcode.p0599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        final Map<String, List<Integer>> map = new HashMap<>();
        buildIndexMap(list1, map);
        buildIndexMap(list2, map);
        int minSum = Integer.MAX_VALUE;
        List<String> cands = new ArrayList<>();
        for (var entry : map.entrySet()) {
            final List<Integer> indices = entry.getValue();
            if (indices.size() < 2) {
                continue;
            }
            final int cand = indices.get(0) + indices.get(1);
            final String key = entry.getKey();
            if (minSum == cand) {
                cands.add(key);
                continue;
            }
            if (minSum > cand) {
                minSum = cand;
                cands = new ArrayList<>();
                cands.add(key);
            }
        }
        return cands.toArray(new String[cands.size()]);
    }

    private static void buildIndexMap(String[] xs, Map<String, List<Integer>> map) {
        for (int i = 0; i < xs.length; i++) {
            final String key = xs[i];
            if (!map.containsKey(key)) {
                final List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(key, indices);
                continue;
            }
            map.get(key).add(i);
        }
    }
}
