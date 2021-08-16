package leetcode.p0160.constantSpace.withoutLen;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;

    // The shorter one can occupy the longer head first and move forward first in the next loop,
    // so our two points will meet in the intersection point in the future.
    while (a != b) {
      a = (a == null) ? headB : a.next;
      b = (b == null) ? headA : b.next;
    }

    return a; // or b
  }
}
