package leetcode.p1477;

import java.util.Arrays;

class Solution {
    // Two subarrays (contiguous) and non-overlapping.
    public int minSumOfLengths(int[] arr, int target) {
        // left := the best in [0, i), right := the best in [i, n)
        // e.g.,
        // arr=[2, 3, 2, 2, 5] and target=7,
        // i=0, left=[], right=[2,5]
        // i=1, left=[], right=[2,5]
        // i=2, left=[], right=[2,5]
        // i=3, left=[2,3,2], right=[2,5]  <------- the answer
        // i=4, left=[2,3,2] or [3,2,2], right=[]
        // i=5, left=[2,5], right=[]
        final int n = arr.length;
        final int[] left = buildLeft(arr, target);
        final int[] right = buildRight(arr, target);
        int bestMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (left[i] == Integer.MAX_VALUE || right[i] == Integer.MAX_VALUE) {
                continue;
            }
            bestMin = Math.min(left[i] + right[i], bestMin);
        }
        return bestMin == Integer.MAX_VALUE ? -1 : bestMin;
    }

    private int[] buildLeft(int[] arr, int target) {
        final int n = arr.length;
        final int[] prefixMinLen = new int[n + 1]; // left
        Arrays.fill(prefixMinLen, Integer.MAX_VALUE);

        int l = 0;
        int r = 0;
        int acc = 0;
        while (l <= r && r < n) {
            if (acc == target) {
                // [l, r)
                prefixMinLen[r] = r - l;
            }
            if (acc < target) {
                acc += arr[r];
                r++;
            } else {
                acc -= arr[l];
                l++;
            }
        }
        while (l < n && acc > target) {
            acc -= arr[l++];
        }
        if (acc == target) {
            // [l, r)
            prefixMinLen[r] = r - l;
        }
        for (int i = 1; i < n + 1; i++) {
            // left -> right 探索中, すでに the best を見つけているあればそれに上書きする.
            // すでに通ってしまったところはそのまま.
            prefixMinLen[i] = Math.min(prefixMinLen[i], prefixMinLen[i - 1]);
        }
        return prefixMinLen;
    }

    private int[] buildRight(int[] arr, int target) {
        final int n = arr.length;
        final int[] suffixMinLen = new int[n]; // right
        Arrays.fill(suffixMinLen, Integer.MAX_VALUE);

        int r = n - 1;
        int l = n - 1;
        int acc = 0;
        while (l <= r && l >= 0) {
            if (acc == target) {
                // (l, r]
                suffixMinLen[l + 1] = r - l;
            }
            if (acc < target) {
                acc += arr[l];
                l--;
            } else {
                acc -= arr[r];
                r--;
            }
        }
        while (r >= 0 && acc > target) {
            acc -= arr[r--];
        }
        if (acc == target) {
            // (l, r]
            suffixMinLen[l + 1] = r - l;
        }
        for (int i = n - 2; i >= 0; i--) {
            // right -> left 探索中, すでに the best を見つけているあればそれに上書きする.
            // すでに通ってしまったところはそのまま.
            suffixMinLen[i] = Math.min(suffixMinLen[i], suffixMinLen[i + 1]);
        }
        return suffixMinLen;
    }
}
