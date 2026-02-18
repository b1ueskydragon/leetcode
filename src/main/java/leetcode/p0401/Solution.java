package leetcode.p0401;

import java.util.ArrayList;
import java.util.List;

class Solution {

    static class V2 {

        public List<String> readBinaryWatch(int turnedOn) {
            final List<String> ans = new ArrayList<>();
            // Merge h bits and m bits.
            // MSB を除く先頭 4 bits = h
            // 末尾 6 bits = m
            // 1 0000 000000
            // 2^10 patterns.
            for (int bits = 0; bits < (1 << 10); bits++) {
                // Head bits 1 0000
                // Shift down to remove tail 6 bits.
                final int h = bits >> 6;

                // Tail bits 000000
                //   1 0000 010011
                // & 0 0000 111111
                // ------------------
                //   0 0000 010011 (Extract 1 bit from tail 6 bits)
                final int m = bits & ((1 << 6) - 1);

                if (h < 12 && m < 60 && bitCount(bits) == turnedOn) {
                    ans.add(String.format("%d:%02d", h, m));
                }
            }
            return ans;
        }

        private static int bitCount(int num) {
            int bits = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    bits++;
                }
                num >>>= 1;
            }
            return bits;
        }

    }

    static class V1 {

        // hour < 12
        // minute < 60
        public List<String> readBinaryWatch(int turnedOn) {
            final List<String> ans = new ArrayList<>();
            for (int n = 0; n <= turnedOn; n++) {
                final int m = turnedOn - n;

                if (n > 4 || m > 6) {
                    continue;
                }

                // hour ∈ {1 << 0, 1 << 1, 1 << 2, 1 << 3}
                final List<Integer> hours = generate(4, new ArrayList<>(), 0, n, 0, 0, 12);

                if (hours.isEmpty()) {
                    continue;
                }

                // minute ∈ {1 << 0, 1 << 1, 1 << 2, 1 << 3, 1 << 4, 1 << 5}
                final List<Integer> minutes = generate(6, new ArrayList<>(), 0, m, 0, 0, 60);

                for (int hour : hours) {
                    for (int minute : minutes) {
                        ans.add(String.format("%d:%02d", hour, minute));
                    }
                }

            }
            return ans;
        }

        // {1, 2, 4, 8} (もしくは {1, 2, 4, 8, 16, 32}) から
        // limit 個を選ぶ.
        // ただ, 要素が全てユニークで選んだあと足すので, 順序なし, 重複なしになる.
        private static List<Integer> generate(
                // Fundamental parameters to build a permutation.
                int shiftCount,
                List<Integer> result,
                int acc,
                int limit,
                // Parameters for an effective filtering (実質 combination になる).
                int pickedCount,
                int from,
                int sumLimit
        ) {
            if (acc >= sumLimit) {
                return result;
            }
            if (pickedCount == limit) {
                result.add(acc);
                return result;
            }

            for (int i = from; i < shiftCount; i++) {
                // 再帰呼び出し毎に新しい pickedCount が作られる (呼び出し元の pickedCount は変わらない).
                // pickedCount だけ渡して, generate 前後で pickedCount += 1 (add), pickedCount -= 1 (remove) しているのと同じ.
                // acc に関しても同じ (add -> recursion -> remove).
                // i + 1 (次の from) に関しては, 重複除去 + 出戻り禁止.
                generate(shiftCount, result, acc + (1 << i), limit, pickedCount + 1, i + 1, sumLimit);
            }

            return result;
        }

    }

}

