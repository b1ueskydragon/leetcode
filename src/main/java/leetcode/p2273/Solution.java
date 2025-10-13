package leetcode.p2273;

import java.util.LinkedList;
import java.util.List;

class Solution {
    // We can delete only an adjacent anagram.
    // 1 <= len(words) <= 100
    // 1 <= len(word) <= 10
    // word consists of lowercases.
    public List<String> removeAnagrams(String[] words) {
        final LinkedList<String> ans = new LinkedList<>();
        ans.add(words[0]);
        for (String word : words) {
            // Compare previous and current words
            if (!isAnagram(ans.getLast(), word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean isAnagram(String w1, String w2) {
        final int n = w1.length();
        if (n != w2.length()) {
            return false;
        }

        final int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[w1.charAt(i) - 'a']++;
            freq[w2.charAt(i) - 'a']--;
        }

        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }
}
