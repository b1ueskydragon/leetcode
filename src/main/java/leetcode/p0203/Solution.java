package leetcode.p0203;

import leetcode.common.ListNode;

// O(N) Time O(1) Space (only two pointers are used).
class Solution {
  public ListNode removeElements(ListNode head, int val) {
    while (head != null && head.val == val) {
      head = head.next;
    }
    ListNode pos = head;
    ListNode bef = null;
    while (pos != null) {
      if (pos.val == val) {
        bef.next = pos.next;
      } else {
        // bef only can go ahead when pos is not the val for the next check
        // since there is the case of the val appearing continuously.
        bef = pos;
      }
      pos = pos.next;
    }
    return head;
  }
}
