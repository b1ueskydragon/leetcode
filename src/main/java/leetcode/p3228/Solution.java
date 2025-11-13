package leetcode.p3228;

class Solution {
    public int maxOperations(String s) {

        // 1のブロックを左->右に移動することで右埋めしていくイメージ
        // e.g.,
        // [1]001101
        // 00[1]1101  ... ここまで 1 swap 必要
        // 00[111]01
        // 000[111]1  ... ここまで 3 swaps 必要

        int ones = 0; // リセットせずどんどん溜まっていくのが正しい
        int ans = 0;
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else if (i == n - 1 || s.charAt(i + 1) == '1') {
                // 0のブロックの右端 (次が 1) or s の終端の時のみ1のブロックの長さを加算
                ans += ones;
            }
        }
        return ans;
    }
}
