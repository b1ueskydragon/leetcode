package leetcode.p0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // 区間に依存する DP e.g., Word Break, Palindrome ... O(N^2) Time complexity が基本
    public boolean wordBreak(String s, List<String> wordDict) {
        // To ensure O(1) lookup
        final Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }

        final int n = s.length();

        // When isValidSoFar[j] = true, [0, j] is valid
        final boolean[] isValidSoFar = new boolean[n + 1];

        // Base case dp[0] がないと valid でも正しく状態 (true) が伝播できないので
        // "" is valid とみなす
        isValidSoFar[0] = true;

        // まず j を fix して i を動かしながら [i,j] の正当性を調べる
        // i == j の場合 substring は "" なので j は 1 start, i < j で OK
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < j; i++) {
                if (!isValidSoFar[i]) {
                    // When any previous section is invalid,
                    // we don't need to (we can't) proceed further
                    continue;
                }
                if (!dict.contains(s.substring(i, j))) {
                    // The current section is not included in the dict
                    continue;
                }
                // section の形に関係なく valid anyway
                isValidSoFar[j] = true;
                // (高速化) No need to look for further valid patterns
                break;
            }
        }

        return isValidSoFar[n];
    }
}
