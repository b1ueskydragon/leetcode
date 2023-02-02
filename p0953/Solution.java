package leetcode.p0953;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        final Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }
        String prev = words[0];
        for (int i = 1; i < words.length; i++) {
            String curr = words[i];
            if (prev.equals(curr)) {
                prev = curr;
                continue;
            }
            final int k1 = prev.length();
            final int k2 = curr.length();
            int j = 0;
            while (true) {
                if (j >= k1 || j >= k2) {
                    if (k1 > k2) {
                        return false;
                    }
                    break;
                }
                final int order1 = indexMap.get(prev.charAt(j));
                final int order2 = indexMap.get(curr.charAt(j));
                if (order1 < order2) {
                    break;
                }
                if (order1 > order2) {
                    return false;
                }
                j++;
            }
            prev = curr;
        }
        return true;
    }
}
