package leetcode.p2563;

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Why we can sort?
        // : ペアを作るので順番は関係ない (Not a Permutation, build a Combination)
        // そもそもの制約 0 <= i < j < n の再解釈
        // : ペアを作る際に自分自身を選ばない, 逆順(重複)をカウントしなくて良い
        Arrays.sort(nums);
        final int n = nums.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            // (nums[i], x),
            // low <= x <= high
            long low = lower - nums[i];
            long high = upper - nums[i];

            // Using Two-pointers at [i+1 ... n-1] to get the range
            // Since i < j, the leftmost starting point is i+1
            int left = binarySearchLeft(nums, i + 1, n - 1, low);
            int right = binarySearchRight(nums, i + 1, n - 1, high);

            if (left <= right) {
                count += (right - left + 1);
            }
        }

        return count;
    }

    // 最初に target より大なりイコールになる index
    private int binarySearchLeft(int[] nums, int l, int r, long target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                // target と同じもここに入る
                // l を返すので target と同じならそれ以上 l を動かしてはいけないため
                r = m - 1;
            }
        }
        return l;
    }

    // 最初に target より小なりイコールになる index
    private int binarySearchRight(int[] nums, int l, int r, long target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                // target と同じもここに入る
                // r を返すので target と同じならそれ以上 r を動かしてはいけないため
                l = m + 1;
            }
        }
        return r;
    }
}
