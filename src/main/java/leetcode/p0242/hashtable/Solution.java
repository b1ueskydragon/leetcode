package leetcode.p0242.hashtable;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Character, Integer> countMap = new HashMap<>();

    public boolean isAnagram(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            final char key = s.charAt(i);
            countMap.put(key, countMap.computeIfAbsent(key, k -> 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            final char key = t.charAt(i);
            if (!countMap.containsKey(key)) {
                return false;
            }
            final int stock = countMap.get(key);
            if (stock == 0) {
                return false;
            }
            countMap.put(key, stock - 1);
        }

        for (int rem : countMap.values()) {
            if (rem > 0) {
                return false;
            }
        }
        return true;
    }
}
