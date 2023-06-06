package leetcode.p1502.straightforward;

import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int interval = arr[1] - arr[0];
        int prev = arr[1];
        for (int i = 2; i < arr.length; i++) {
            final int curr = arr[i];
            if (curr - prev != interval) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
