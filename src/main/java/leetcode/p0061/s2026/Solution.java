package leetcode.p0061.s2026;

import leetcode.common.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode last = head; // non-null
        int n = 1;
        while (last.next != null) {
            last = last.next;
            n++;
        }
        last.next = head; // cycle at this point
        for (int i = 0; i < n - (k + 1) % n; i++) {
            head = head.next;
        }
        // From now, the cutting point is between head and head.next.
        ListNode newHead = head.next;
        head.next = null; // cut the cycle
        return newHead;
    }
}
