package leetcode.p0763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Constraints: s consists of lowercase English letters.
    public List<Integer> partitionLabels(String s) {
        final int n = s.length();
        final int[] lastIndex = new int[26];
        for (int i = 0; i < n; i++) {
            final int charNum = s.charAt(i) - 'a';
            lastIndex[charNum] = i;
        }

        final List<Integer> parts = new ArrayList<>();
        int l = 0;
        int r = 0;
        int left = l;
        while (l < n && r < n) {
            r = Math.max(lastIndex[s.charAt(l) - 'a'], lastIndex[s.charAt(r) - 'a']);
            while (l < r) {
                l++;
                r = Math.max(lastIndex[s.charAt(l) - 'a'], lastIndex[s.charAt(r) - 'a']);
            }
            parts.add(r - left + 1);
            l = r + 1;
            left = l;
        }

        return parts;
    }
}
