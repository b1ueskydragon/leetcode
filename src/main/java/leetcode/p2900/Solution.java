package leetcode.p2900;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // Constraint: n <= 100, words.length == groups.length
        final int n = words.length;
        final List<List<String>> soFar = new ArrayList<>();
        soFar.add(List.of(words[0]));
        for (int i = 1; i < n; i++) {
            if (groups[i] == groups[i - 1]) {
                // Just take over the previous result
                soFar.add(soFar.get(i - 1));
                continue;
            }
            // To get the longest,
            // we can simply use the previous result and accumulate the new word
            final List<String> newList = new ArrayList<>(soFar.get(i - 1));
            newList.add(words[i]);
            soFar.add(newList);
        }

        return soFar.get(n - 1);
    }
}
