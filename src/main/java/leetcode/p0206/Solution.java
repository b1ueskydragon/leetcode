package leetcode.p0206;

import leetcode.common.ListNode;

class Solution {
  // head, res, prev, tmp .. they're just pointers.
  // But they are sharing the same object and they can change the object at the same way.
  public ListNode reverseList(ListNode head) {
    ListNode res = head;
    ListNode prev = null;
    while (head != null) {
      ListNode tmp = head.next; // copy the `pointer` first. Separate the `next`.
      res.next = prev;
      prev = res; // move to the prev.
      head = tmp;
      res = head;
    }
    return prev;
  }
}
