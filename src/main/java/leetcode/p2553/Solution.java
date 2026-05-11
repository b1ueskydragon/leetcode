package leetcode.p2553;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] separateDigits(int[] nums) {
        final Deque<Integer> stack = new ArrayDeque<>();
        final int n = nums.length;
        int len = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int d = 0;
            while (num > 0) {
                stack.push(num % 10);
                len++;
                num /= 10;
            }
        }
        final int[] ans = new int[len];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.poll();
        }
        return ans;
    }
}
