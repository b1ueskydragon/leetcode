package leetcode.p1081;

import java.util.ArrayDeque;

class Solution {
    public String smallestSubsequence(String s) {
        // Unique characters and sorted ascending.
        // e.g.,
        // bcac
        // unique patterns are `bca`, `bac`
        // We'd rather pick the latter.
        final int n = s.length();
        final int[] lastOccurrence = new int[26];
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            lastOccurrence[c - 'a'] = i;
        }
        final boolean[] used = new boolean[26];
        final var stack = new ArrayDeque<Character>();
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if (used[c - 'a']) {
                continue;
            }
            // push する前にお掃除するか(そうすることで左に繰り上がる), そのまま push するか.
            while (!stack.isEmpty()
                    // Pop only if this character appears again later.
                    && lastOccurrence[stack.peek() - 'a'] > i
                    // Prefer the smaller character earlier in the result.
                    && stack.peek() > c) {
                // See you later alligator.
                used[stack.peek() - 'a'] = false;
                stack.poll();
            }
            stack.push(c);
            used[c - 'a'] = true;
        }
        final var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
