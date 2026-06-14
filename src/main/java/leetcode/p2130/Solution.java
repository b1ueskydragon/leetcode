package leetcode.p2130;

import leetcode.common.ListNode;

class Solution {
    public int pairSum(ListNode head) {
        // Always even due to the constraint.
        int n = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            n++;
        }
        // e.g.,
        // 0, 1, 2, 3, 4, 5, 6, 7
        // ^                    ^   [0] + [7]
        //    ^              ^      [1] + [6]
        //       ^        ^         [2] + [5]
        //          ^  ^            [3] + [4]
        //
        // 0, 1, 2, 3
        final int[] left = new int[n / 2];
        // 7, 6, 5, 4 (reversed order)
        final int[] right = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            left[i] = head.val;
            head = head.next;
        }
        int j = 0;
        while (head != null) {
            right[n / 2 - 1 - j] = head.val;
            head = head.next;
            j++;
        }
        int max = 0;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }
}
