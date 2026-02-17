package leetcode.p0401;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final List<Integer> H = List.of(1, 2, 4, 8);
    private static final List<Integer> M = List.of(1, 2, 4, 8, 16, 32);

    // hour < 12
    // minute < 60
    public List<String> readBinaryWatch(int turnedOn) {
        final List<String> ans = new ArrayList<>();
        for (int n = 0; n <= turnedOn; n++) {
            final int m = turnedOn - n;
            final List<Integer> hours = generate(
                    H, new ArrayList<>(), new ArrayList<>(n), n,
                    0, new boolean[H.size()], 12);

            if (hours.isEmpty()) {
                continue;
            }

            final List<Integer> minutes = generate(
                    M, new ArrayList<>(), new ArrayList<>(m), m,
                    0, new boolean[M.size()], 60);


            for (int hour : hours) {
                for (int minute : minutes) {
                    ans.add(String.format("%d:%02d", hour, minute));
                }
            }

        }
        return ans;
    }

    private static List<Integer> generate(
            // Fundamental parameters to build a permutation.
            List<Integer> given,
            List<Integer> result,
            List<Integer> acc,
            int limit,
            // Parameters for an effective filtering.
            int lastAppended,
            boolean[] used,
            int sumLimit
    ) {
        if (acc.size() == limit) {
            int sum = 0;
            for (int num : acc) {
                sum += num;
            }
            if (sum < sumLimit) {
                result.add(sum);
            }
            return result;
        }

        for (int i = 0; i < given.size(); i++) {
            if (i < lastAppended) { // 後ろの index append 対策
                continue;
            }
            if (used[i]) { // 重複対策
                continue;
            }
            acc.add(given.get(i));
            used[i] = true;

            generate(given, result, acc, limit, i, used, sumLimit);

            acc.remove(acc.size() - 1); // 最後の1文字を消すことで選択をrevert
            used[i] = false;
        }

        return result;
    }

}

