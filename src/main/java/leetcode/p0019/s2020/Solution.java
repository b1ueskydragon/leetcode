package leetcode.p0019.s2020;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p = new ListNode(0); // sentinel
    p.next = head; // pointer

    // the entire length is N, follow should find(move) N-n th node.
    ListNode p1 = p; // ahead
    ListNode p2 = p; // follows

    // ahead first find n th node.
    while (n > 0) {
      p1 = p1.next;
      n--;
    }

    if (p1.next == null) { // edge case for N-n == n.
      return head.next;
    }

    // now ahead moves remaining distance, that's N-n.
    // follows moves N-n too.
    // p2 stops before the skip target.
    while (p1.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    // now we can skip N-n th.
    p2.next = p2.next.next;
    return head;
  }
}
