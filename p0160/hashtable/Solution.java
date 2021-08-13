package leetcode.p0160.hashtable;

import java.util.HashSet;
import java.util.Set;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class Solution {
  // Make a cycle intentionally. Straight-forward, O(N) space, O(N) time.
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;

    int aLen = 1;
    while (a.next != null) {
      a = a.next;
      aLen++;
    }

    int bLen = 1;
    while (b.next != null) {
      b = b.next;
      bLen++;
    }

    ListNode aEnd = a;
    a.next = headB;

    final Set<ListNode> checked = new HashSet<>();

    int i = 0;
    while (i < aLen + bLen) {
      if (checked.contains(headA)) {
        aEnd.next = null;
        return headA;
      }
      checked.add(headA);
      headA = headA.next;
      i++;
    }

    aEnd.next = null;

    return null;
  }
}
