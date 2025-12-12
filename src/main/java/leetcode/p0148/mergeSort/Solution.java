package leetcode.p0148.mergeSort;

import leetcode.common.ListNode;

class Solution {
    // merge sort (Top down)
    // repeat merging sorted list a and sorted list b
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // divide Phase
        ListNode midPrev = null;
        ListNode mid = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            midPrev = mid;
            mid = mid.next;
            fast = fast.next.next;
        }
        // cut off the linkage between mid and midPrev
        midPrev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // conquer Phase
        return sortAndMerge(left, right);
    }

    // both a and b are sorted lists
    private ListNode sortAndMerge(ListNode a, ListNode b) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        // flush
        // at this point either or both will be null
        p.next = (a != null) ? a : b;

        return head.next;
    }
}
