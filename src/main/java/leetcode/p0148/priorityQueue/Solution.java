package leetcode.p0148.priorityQueue;

import java.util.PriorityQueue;

class Solution {
    public ListNode sortList(ListNode head) {
        final PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.val < o2.val) return -1;
            else if (o1.val == o2.val) return 0;
            return 1;
        });

        while (head != null) {
            pq.offer(head);
            head = head.next;
        }

        head = new ListNode(); // sentinel
        final ListNode res = head;

        while (!pq.isEmpty()) {
            final ListNode node = pq.poll();
            node.next = null; // cut-off the original linkage
            head.next = node;
            head = head.next;
        }

        return res.next;
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
