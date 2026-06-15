package leetcode.p2095;

import leetcode.common.ListNode;

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            // An empty or a single node.
            return null;
        }
        // Move double steps to position the slow in the center eventually.
        ListNode fast = head;
        // This will be a center.
        // If even, the middle is a right-aligned center.
        ListNode slow = head;
        // The previous slow.
        ListNode prev = null;
        while (slow != null && (fast != null && fast.next != null)) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
