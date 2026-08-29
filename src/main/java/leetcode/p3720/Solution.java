package leetcode.p3720;

import java.util.ArrayDeque;

class Solution {
    public String lexGreaterPermutation(String s, String target) {

        // e.g.,
        // bx4 dx1 cx1
        // bbbbdz
        //
        // bbbbd
        // bbbb
        // bbb
        // bbbc
        // bbbcb
        // bbbcbd

        final int[] freq = new int[26];
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        final var stack = new ArrayDeque<Character>();
        boolean alwaysValid = false;
        while (stack.size() < n) {
            final char c = target.charAt(stack.size());

            // Already (always) valid: Find the smallest available one
            // Otherwise: Find the larger or equal to c
            int i = alwaysValid ? 0 : c - 'a';
            while (i < 26 && freq[i] == 0) {
                i++;
            }

            // Need backtracking.
            if (i == 26) {
                // No more characters to try.
                if (stack.isEmpty()) {
                    return "";
                }
                alwaysValid = isValidAfterBacktrack(stack, freq, alwaysValid);
                // while で一通り回したが, bump up して valid であるものは見つからず.
                // 最初に戻る必要もない.
                if (!alwaysValid) {
                    return "";
                }
            }
            // No need to backtrack.
            else {
                stack.push((char) (i + 'a'));
                freq[i]--;
                if (i + 'a' > c) {
                    // Bumped up. この時点でからなず target より大きい.
                    alwaysValid = true;
                }
            }

            if (stack.size() == n) {
                final var tmp = stack.clone();
                boolean isIdentical = true;
                for (int index = n - 1; index >= 0; index--) {
                    // At least a one diff makes it false.
                    isIdentical &= target.charAt(index) == tmp.pop();
                }
                // 一度完成はしている. せっかく見つかった "最小" は完全イコールだった.
                if (isIdentical) {
                    alwaysValid = isValidAfterBacktrack(stack, freq, alwaysValid);
                    // while で一通り回したが, bump up して valid であるものは見つからず.
                    // 最初に戻る必要もない.
                    if (!alwaysValid) {
                        return "";
                    }
                }
            }
        }

        final var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private boolean isValidAfterBacktrack(
            ArrayDeque<Character> stack,
            int[] freq,
            boolean alwaysValid
    ) {
        // bump up できそうなところまで前に下がる. 必要な分だけ戻るため while.
        while (!stack.isEmpty()) {
            // Backtrack. 選択の取り消し.
            int j = stack.pop() - 'a';
            freq[j]++;
            // Bump up. 新しい選択.
            j++;
            while (j < 26 && freq[j] == 0) {
                j++;
            }
            if (j < 26) {
                stack.push((char) (j + 'a'));
                freq[j]--;
                // この時点でからなず target より大きい.
                alwaysValid = true;
                // 見つかったのでこれ以上 while 不要.
                break;
            }
        }
        return alwaysValid;
    }
}
