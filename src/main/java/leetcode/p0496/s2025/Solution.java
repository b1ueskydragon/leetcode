package leetcode.p0496.s2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    // 「次に (curr から最も近い) 大きい値」を見つける ... monotonic stack
    // Constraints:
    // - All numbers in nums1, nums2 are unique
    // - nums2 ⊃ nums1
    // - All numbers are in the range of [0, 10000]
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int[] result = new int[n];

        // nums1 value -> nums2 index
        final Map<Integer, Integer> mapping = buildMap(nums1, nums2);
        // nums2 index -> nums2 next greater value's index
        final Map<Integer, Integer> nextGreaters = buildNextGreaters(nums2);

        for (int i = 0; i < n; i++) {
            final int j = nextGreaters.getOrDefault(mapping.get(nums1[i]), -1);
            result[i] = (j == -1) ? -1 : nums2[j];
        }
        return result;
    }

    private Map<Integer, Integer> buildMap(int[] nums1, int[] nums2) {
        // nums2 value -> nums2 index
        final Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], i);
        }

        // nums1 value -> nums2 index
        final Map<Integer, Integer> map1 = new HashMap<>();
        for (int num1 : nums1) {
            // since the constraint of nums2 ⊃ nums1, #get is okay
            map1.put(num1, map2.get(num1));
        }

        return map1;
    }

    private Map<Integer, Integer> buildNextGreaters(int[] nums) {
        // currNum より大きい num の index を積み上げていく
        // 多分 top -> bottom の順に大きくなる
        final Stack<Integer> stack = new Stack<>();

        // nums index -> next greater's index in nums
        final Map<Integer, Integer> nextGreaters = new HashMap<>();

        // 「次に大きい」なので後ろから走査する
        for (int i = nums.length - 1; i >= 0; i--) {
            int currNum = nums[i];
            // currNum 的に自分より小さい
            while (!stack.isEmpty() && nums[stack.peek()] < currNum) {
                stack.pop();
            }
            // pop しない, 次の(未来の) currNum さんが使うかも
            if (!stack.isEmpty()) {
                nextGreaters.put(i, stack.peek());
            }
            stack.push(i);
        }

        return nextGreaters;
    }
}
