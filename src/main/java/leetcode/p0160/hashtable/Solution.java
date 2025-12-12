package leetcode.p0160.hashtable;

import leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  // Straight-forward, O(N) space, O(N) time.
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    final Set<ListNode> checked = new HashSet<>();

    while (headA != null) {
      checked.add(headA);
      headA = headA.next;
    }

    while (headB != null) {
      if (checked.contains(headB)) {
        return headB;
      }
      headB = headB.next;
    }

    return null;
  }
}
