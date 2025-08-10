package leetcode.p0869;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public boolean reorderedPowerOf2(int n) {
        final int count = countDigit(n);
        final int[] nFreq = getFrequencies(n);
        final var table = buildTable();

        for (int cand : table.get(count)) {
            if (Arrays.equals(nFreq, getFrequencies(cand))) {
                return true;
            }
        }
        return false;
    }

    private static int countDigit(final int n) {
        int x = n;
        int cnt = 0;
        while (x > 0) {
            x /= 10;
            cnt++;
        }
        return cnt;
    }

    private static Map<Integer, List<Integer>> buildTable() {
        final Map<Integer, List<Integer>> table = new HashMap<>();
        // Constraints: 1 <= n <= 10^9
        for (int i = 0; i < 31; i++) {
            final int x = 1 << i;
            final int count = countDigit(x);
            table.computeIfAbsent(count, key -> new ArrayList<>()).add(x);
        }
        return table;
    }

    private static int[] getFrequencies(final int n) {
        // Digit, 0~9
        final int[] freq = new int[10];
        int x = n;
        while (x > 0) {
            freq[x % 10]++;
            x /= 10;
        }
        return freq;
    }
}
