package leetcode.p0024.recursion;

import leetcode.common.ListNode;

class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode a = head.next; // keep it before disconnecting
    ListNode b = swapPairs(head.next.next);
    head.next = b;
    a.next = head;
    return a;
  }
}
