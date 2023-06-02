package leetcode.p0692.easy_solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(N logN) execution time, O(N) extra space
class Solution {
    // 1 <= words.length <= 500
    // 1 <= words[i].length <= 10
    public List<String> topKFrequent(String[] words, int k) {
        final Map<String, Integer> freqMap = new HashMap<>();
        for (String w : words) {
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }
        final List<Map.Entry<String, Integer>> freqEntries = new ArrayList<>(freqMap.entrySet());
        freqEntries.sort((n1, n2) -> {
            // first, sort by Value (frequency)
            // next, if the result of the first was equal, sort by Key (lexicographical order)
            final int firstRes = n2.getValue().compareTo(n1.getValue());
            return (firstRes == 0) ? n1.getKey().compareTo(n2.getKey()) : firstRes;
        });
        final List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(freqEntries.get(i).getKey());
        }
        return res;
    }
}
