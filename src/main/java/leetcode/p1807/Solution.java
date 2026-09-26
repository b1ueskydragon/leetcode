package leetcode.p1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        final Map<String, String> dict = new HashMap<>();
        for (var list : knowledge) {
            // Each key_i in knowledge is unique.
            // knowledge[i].length == 2
            dict.put(list.get(0), list.get(1));
        }
        final var ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            // s consists of lowercase English letters and round brackets '(' and ')'.
            // Every open bracket '(' in s will have a corresponding close bracket ')'.
            // The key in each bracket pair of s will be non-empty.
            // There will not be any nested bracket pairs in s.
            if (s.charAt(i) == '(') {
                final var sb = new StringBuilder();
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    sb.append(s.charAt(j));
                    j++;
                }
                ans.append(dict.getOrDefault(sb.toString(), "?"));
                i = j + 1;
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}
