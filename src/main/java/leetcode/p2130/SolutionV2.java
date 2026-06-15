package leetcode.p2130;

import leetcode.common.ListNode;

class SolutionV2 implements Solution {

    public int pairSum(ListNode head) {
        // Always even due to the constraint.
        ListNode fast = head;
        // Right-aligned center.
        ListNode slow = head;
        ListNode rightHead = new ListNode(0);
        while (slow != null && fast != null && fast.next != null) {
            // Init next is null, so the end is null.
            ListNode last = rightHead.next;
            rightHead.next = slow;

            // Move slow first to the next before linking rightHead.
            slow = slow.next;
            fast = fast.next.next;

            rightHead.next.next = last;
        }

        ListNode left = slow;
        ListNode right = rightHead.next;

        // 1, 2, 3, 4, 5, 6, 7, 8
        //          ^  ^
        //           ↓
        // 5, 6, 7, 8, 4, 3, 2, 1
        // ^           ^

        int max = 0;
        while (left != null) {
            max = Math.max(max, left.val + right.val);
            left = left.next;
            right = right.next;
        }
        return max;
    }

}
