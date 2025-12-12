package leetcode.p0061;

import leetcode.common.ListNode;

class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }

    ListNode last = head;
    int n = 1;
    while (last.next != null) {
      last = last.next;
      n++;
    }

    last.next = head;

    int step = n - (k % n);
    while (step > 1) {
      head = head.next;
      step--;
    }

    ListNode first = head.next;
    head.next = null;

    return first;
  }
}
