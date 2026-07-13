package leetcode.p1291;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        // At most 36 cases, so generate them all.
        // To preserve the order without sorting, store them in an 8x8 matrix.
        // 12      23      ...
        // 123     234
        // 1234    2345
        // 12345   23456
        // ...
        final int[][] mat = new int[8][8];
        int seed = 12;
        int j = 0;
        while (seed < 100) {
            int num = seed;
            int d = seed % 10 + 1;
            int i = 0;
            while (d <= 10) {
                mat[i++][j] = num;
                num = num * 10 + d++;
            }
            seed += 11;
            i = 0;
            j++;
        }
        final List<Integer> ans = new ArrayList<>();
        for (int[] xs : mat) {
            for (int x : xs) {
                if (x != 0 && x >= low && x <= high) {
                    ans.add(x);
                }
            }
        }
        return ans;
    }
}
