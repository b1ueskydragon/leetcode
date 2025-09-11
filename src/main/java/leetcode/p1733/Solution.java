package leetcode.p1733;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // You can choose one language.
    // The result is the minimum number of people to teach.
    // Index starts with 1.
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // Pre-compute
        final int people = languages.length;
        final boolean[][] knows = new boolean[people + 1][n + 1];
        for (int i = 0; i < people; i++) {
            for (int l : languages[i]) {
                knows[i + 1][l] = true;
            }
        }

        // Need to teach
        // Keep people unique
        final Set<Integer> candidates = new HashSet<>();
        for (int[] tuple : friendships) {
            final int u = tuple[0];
            final int v = tuple[1];
            if (hasCommon(knows, n, u, v)) {
                continue;
            }
            candidates.add(u);
            candidates.add(v);
        }

        final int needToLearn = candidates.size();

        if (needToLearn == 0) {
            return 0;
        }

        final int[] freq = new int[n + 1];
        for (int cand : candidates) {
            for (int lang : languages[cand - 1]) {
                freq[lang]++;
            }
        }

        int maxF = 0;
        for (int f : freq) {
            maxF = Math.max(f, maxF);
        }

        // To minimize the number of people to teach any single language
        // we need to pick the language with the highest overlap with the candidates.
        // `x` is a language,
        // Any candidate who already knows `x` doesn’t need to be taught.
        // Any candidate who doesn’t know `x` must be taught `x`.
        return needToLearn - maxF;
    }

    private static boolean hasCommon(boolean[][] knows, int n, int person1, int person2) {
        // Scan languages
        for (int i = 1; i <= n; i++) {
            if (knows[person1][i] && knows[person2][i]) {
                return true;
            }
        }
        return false;
    }
}
