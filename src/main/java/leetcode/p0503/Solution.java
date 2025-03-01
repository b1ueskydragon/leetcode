package leetcode.p0503;

import java.util.ArrayDeque;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        final int n = nums.length;
        final int[] res = new int[n];
        // Write only values which are `bigger` than current focusing value.
        // We don't need to get a distance, put a value rather than an index would be fine.
        // But I'll just put an index.
        final ArrayDeque<Integer> stack = new ArrayDeque<>();

        // e.g.
        // if given is [1,2,4,3] (circular),
        // make a linear search from below will be fine.
        // [1,2,4,3,1,2,4]
        final int circularN = 2 * n - 1;
        // We need to pick values from the right side of current focusing value,
        // so a reverse order is needed.
        for (int i = circularN - 1; i >= 0; i--) {
            int index = (i > n - 1) ? i % n : i;
            // `bigger` values than the current focusing index's value are unnecessary.
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[index]) {
                stack.pop();
            }
            // write doubly to res is fine.
            res[index] = !stack.isEmpty() ? nums[stack.peek()] : -1;
            stack.push(index);
        }
        return res;
    }
}
