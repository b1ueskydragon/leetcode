package leetcode.p2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Solution {

    static class V2 {

        public int nextBeautifulNumber(int n) {
            if (n == 0) {
                return 1;
            }
            final Map<Integer, List<List<Integer>>> map =
                    Map.of(
                            1, List.of(List.of(1)),
                            2, List.of(List.of(2, 2)),
                            3, List.of(List.of(1, 2, 2), List.of(3, 3, 3)),
                            4, List.of(List.of(1, 3, 3, 3), List.of(4, 4, 4, 4)),
                            5, List.of(List.of(1, 4, 4, 4, 4), List.of(2, 2, 3, 3, 3), List.of(5, 5, 5, 5, 5)),
                            6, List.of(List.of(1, 2, 2, 3, 3, 3), List.of(1, 5, 5, 5, 5, 5), List.of(2, 2, 4, 4, 4, 4), List.of(6, 6, 6, 6, 6, 6)),
                            // Note: digit7 = Only 1224444 due to the constraint n<=10^6
                            7, List.of(List.of(1, 2, 2, 4, 4, 4, 4))
                    );

            int num = n;
            int d = 0;
            while (num > 0) {
                num /= 10;
                d++;
            }

            final List<List<Integer>> cand = new ArrayList<>(map.get(d));
            if (d <= 6) {
                cand.addAll(map.get(d + 1));
            }
            final List<Integer> res = new ArrayList<>();
            for (List<Integer> digits : cand) {
                backtrack(digits, new ArrayList<>(), res, new boolean[digits.size()]);
            }
            // Sort the result just for sure
            Collections.sort(res);
            for (int x : res) {
                if (x > n) {
                    return x;
                }
            }

            return 1224444;
        }

        // 部分集合ではなく, すべての要素を使って異なる順序 permutations を作る. 後ろに戻ることがある ... for-loop backtracking
        // To skip duplicates, `digits` must be sorted
        private void backtrack(List<Integer> digits, List<Integer> path, List<Integer> res, boolean[] used) {
            if (path.size() == digits.size()) {
                int num = 0;
                for (int x : path) {
                    num += x;
                    num *= 10;
                }
                res.add(num / 10);
                return;
            }
            for (int i = 0; i < digits.size(); i++) {
                if (used[i]) {
                    // Used index, skip to avoid duplicate
                    // Just proceed the index i
                    // Go → way
                    continue;
                }
                if (i > 0 && digits.get(i) == digits.get(i - 1) && !used[i - 1]) {
                    // 同じ value の場合, すでに前の順番の値を使っている場合のみ append する
                    // Same digit but not used yet. Skip to avoid the future duplicate
                    // Go → way
                    continue;
                }

                path.add(digits.get(i));
                used[i] = true;
                // Go ↓ way
                backtrack(digits, path, res, used);
                // Reset: Remove the most recent element
                path.remove(path.size() - 1);
                // Revert the status
                used[i] = false;
            }
        }

    }

    static class V1 {
        // Due to the constraint 0 <= n <= 10^6,
        // The maximum balanced number is 1224444,
        // Brute force is acceptable.
        private static final int LIMIT = 1224444;
        private static final int MAX_D = 6;

        public int nextBeautifulNumber(int n) {
            for (int num = n + 1; num < LIMIT; num++) {
                if (isBalanced(num)) {
                    return num;
                }
            }
            return LIMIT;
        }

        private static boolean isBalanced(int num) {
            final int[] freq = new int[MAX_D + 1];
            while (num > 0) {
                final int d = num % 10;
                if (d > MAX_D || d == 0) {
                    // Cannot consist the balance number
                    return false;
                }
                freq[d]++;
                if (freq[d] > d) {
                    return false;
                }
                num /= 10;
            }
            for (int d = 1; d <= MAX_D; d++) {
                if (freq[d] == 0) {
                    continue;
                }
                if (freq[d] != d) {
                    return false;
                }
            }
            return true;
        }

    }

}
