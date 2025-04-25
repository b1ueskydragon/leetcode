package leetcode.p0019.s2025;

class Solution {
    static class V1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // From left side, (size - n) th, 0 started index
            int size = 0;
            ListNode sz = head;
            while (sz != null) {
                sz = sz.next;
                size++;
            }

            int target = size - n;
            int i = 0;
            ListNode prev = null;
            ListNode worker = head;
            while (i < target) {
                prev = worker;
                worker = worker.next;
                i++;
            }

            if (prev == null) {
                // Edge case: Single node (size == 1) or Remove a head (n == size)
                return head.next;
            }
            prev.next = worker.next;
            return head;
        }
    }
}
