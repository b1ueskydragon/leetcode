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
    //
    // A len = a + c
    // B len = b + c
    //
    // Pointer A moves
    //    a + c + b + c (b + c moves after switching pointer)
    // Pointer B moves
    //    b + c + a + c (a + c moves after switching pointer)
    //  so Pointer A and B meet after a + c + b (b + c + a) steps.
    while (a != b) {
      a = (a == null) ? headB : a.next;
      b = (b == null) ? headA : b.next;
    }

    return a; // or b
  }
}
