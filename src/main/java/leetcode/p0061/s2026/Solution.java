package leetcode.p0061.s2026;

import leetcode.common.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode last = head;
        int n = 1;
        while (last != null && last.next != null) {
            last = last.next;
            n++;
        }
        ListNode newHead = head;
        ListNode prev = null;
        for (int i = 0; i < n - k % n; i++) {
            prev = newHead;
            newHead = newHead.next;
        }
        if (newHead == null) {
            return head;
        }
        prev.next = null;
        last.next = head;
        return newHead;
    }
}
