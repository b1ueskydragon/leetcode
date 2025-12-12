package leetcode.p0160.constantSpace.knowingLen;


import leetcode.common.ListNode;

class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;

    int lenA = 0;
    while (a != null) {
      lenA++;
      a = a.next;
    }

    int lenB = 0;
    while (b != null) {
      lenB++;
      b = b.next;
    }

    int diff = Math.abs(lenA - lenB);

    // Align start points
    while (diff > 0) {
      if (lenA > lenB) {
        headA = headA.next;
      } else {
        headB = headB.next;
      }
      diff--;
    }

    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }

    return headA; // or headB
  }
}
