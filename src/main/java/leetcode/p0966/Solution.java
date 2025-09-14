package leetcode.p0966;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    // 1 <= wordlist.length, queries.length <= 5000
    // 1 <= wordlist[i].length, queries[i].length <= 7

    private static final int OFFSET = 'a' - 'A';

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String[] spellchecker(String[] wordlist, String[] queries) {

        // Priority of each words
        // 1. Exactly matches (Exclusive case)
        // 2. Capitalization, the leftmost rule is prioritized among the same rules (Primary check)
        // 3. Vowel errors, the leftmost rule is prioritized among the same rules (Secondary check)

        final int n = queries.length;
        final String[] res = new String[n];

        final Set<String> exactlyMatch = Arrays.stream(wordlist).collect(Collectors.toUnmodifiableSet());

        // Mapping of key -> the first matched rule
        final Map<String, String> pairs = new HashMap<>();
        for (String word : wordlist) {
            final String key = buildKey(word);
            // For the primary check
            // Put the first case only
            pairs.putIfAbsent(key, word);

            // For the secondary check
            // Put the first case only
            pairs.putIfAbsent(maskKey(key), word);
        }

        for (int i = 0; i < n; i++) {
            final String query = queries[i];

            // Exclusive case
            if (exactlyMatch.contains(query)) {
                res[i] = query;
                continue;
            }

            // Primary check
            final String key = buildKey(query);
            if (pairs.get(key) != null) {
                res[i] = pairs.get(key);
                continue;
            }

            // Secondary check
            final String masked = maskKey(key);
            if (pairs.get(masked) != null) {
                res[i] = pairs.get(masked);
                continue;
            }

            // None of those
            res[i] = "";
        }

        return res;
    }

    // To a lower case string
    private static String buildKey(String s) {
        final var sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append((char) ((c < 97) ? c + OFFSET : c));
        }
        return sb.toString();
    }

    // Mask vowels
    // Keys should be converted to the lower case string in advance
    private static String maskKey(String key) {
        final var sb = new StringBuilder();
        for (char c : key.toCharArray()) {
            sb.append(VOWELS.contains(c) ? '*' : c);
        }
        return sb.toString();
    }
}
