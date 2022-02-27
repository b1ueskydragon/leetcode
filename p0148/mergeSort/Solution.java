package leetcode.p0148.mergeSort;

class Solution {
    // merge sort (Top down)
    // repeat merging sorted list a and sorted list b
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // divide Phase
        ListNode mid = splitAndGetMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // conquer Phase
        return sortAndMerge(left, right);
    }

    // side-effect to split a linkage
    // this requires at least two nodes
    private ListNode splitAndGetMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        // cut off the linkage between mid and mid-previous to prevent cycle occurs
        midPrev.next = null;
        return mid;
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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
