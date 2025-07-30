package leetcode.p2411;

class Solution {
    // Subarray (contiguous), Not a subset
    public int[] smallestSubarrays(int[] nums) {
        final int n = nums.length;
        final int[] res = new int[n];

        // 32 bits 整数として各ビット位置 (0~31) を想定 (0 <= nums[i] <= 10^9)
        //  _    _     _      ...     _    _
        // (31)  (30)  (29)  ...    (1)   (0)
        // `nums` を右 -> 左 走査する中で,
        // 各ビットが 1 である値が最後に登場した index (rightmost index)を記録する。
        // 左側で同じビットが 1 の値が見つかったら, その index に上書きされる
        final int[] pos = new int[32];
        for (int i = n - 1; i >= 0; i--) {
            // bits は単に 32 bits 目を Most Significant Bit 側に置きたくて 右 -> 左 走査している
            for (int bit = 31; bit >= 0; bit--) {
                // `nums[i]` の各 bit が 1 or 0 か検出する
                // e.g., 16 & (1 << 4)
                // == 10000(2) & 10000(2)
                // == 10000(2)
                if ((nums[i] & (1 << bit)) != 0) {
                    // Update
                    pos[bit] = i;
                }
            }
            int j = i;
            // ここも (bits) 単に 32 bits 目を Most Significant Bit 側に置いているので 右 -> 左 走査している
            for (int bit = 31; bit >= 0; bit--) {
                // その位置で可能な MAX OR を作るために必要な MIN distance
                // OR 演算のため, 一度任意の position に 1 bit が登場すれば, さらに右の位置でその `1 bit を持ってこなくて良い
                // `nums` を右 -> 左 走査しているため　`pos` には, まだ `i` より左側の情報は入っていない
                if (pos[bit] > j) {
                    j = pos[bit];
                }
            }
            res[i] = j - i + 1;
        }
        return res;
    }
}
